package com.insomniacs.photop;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by INSODROID1 on 23-03-2018.
 */

public class Util {

    private static final String TAG = "PROBLEM";

    public static void TakeScreenshot(View CamView, Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int nu = preferences.getInt("image_num", 0);
        nu++;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("image_num", nu);
        editor.commit();
        CamView.setDrawingCacheEnabled(true);
        CamView.buildDrawingCache(true);
        Bitmap bmp = Bitmap.createBitmap(CamView.getDrawingCache());
        CamView.setDrawingCacheEnabled(false);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] bitmapdata = bos.toByteArray();
        ByteArrayInputStream fis2 = new ByteArrayInputStream(bitmapdata);

        String picId = String.valueOf(nu);
        String myfile = "MyImage" + picId +".jpeg";

      //  storeBitmap(bmp, myfile);

        File dir_image = new File(Environment.getExternalStorageDirectory() +
                File.separator + "My Custom Folder");
        dir_image.mkdirs();

        try {
            File tmpFile = new File(dir_image, myfile);
            FileOutputStream fos = new FileOutputStream(tmpFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis2.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            fis2.close();
            fos.close();

            Toast.makeText(context,
                    "The file is saved at :/My Custom Folder/" + "MyImage" + picId + ".jpeg", Toast.LENGTH_LONG).show();

//            bmp1 = null;
//            camera_image.setImageBitmap(bmp1);
//            camera.startPreview();
//            button1.setClickable(true);
//            button1.setVisibility(View.VISIBLE);//<----UNHIDE HER
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void storeBitmap(final Bitmap bitmap, final String fileUniqueName) {
        if (!isExternalStorageWritable()) {
            Log.e(TAG, "External Storage is not Available or Writable!");
            return;
        }

        new AsyncTask<Void, Void, File>() {
            @Override
            protected File doInBackground(Void... params) {
                File file = null;
                try {
                    file = getOutputMediaFile(fileUniqueName);
                    file.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                } catch (Exception e) {
                    Log.e(TAG, "External Storage problem");
                    e.printStackTrace();
                }
                return file;
            }
        }.execute();
    }


    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static File getOutputMediaFile(String fileUniqueName) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory() +
                File.separator + "My Custom Folder");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        // Create a media file name
        String mImageName = fileUniqueName + ".jpg";
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }
}
