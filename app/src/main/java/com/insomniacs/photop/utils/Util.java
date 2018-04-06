package com.insomniacs.photop.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.insomniacs.photop.IOnFileSaveSuccessFul;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * Created by INSODROID1 on 23-03-2018.
 */

public class Util {

    private static final String TAG = "PROBLEM";

    public static void TakeScreenshot(ProgressBar progressBar, View CamView, Object object, String imageFileName) {


        CamView.setDrawingCacheEnabled(true);
        CamView.buildDrawingCache(true);
        Bitmap bmp = Bitmap.createBitmap(CamView.getDrawingCache());
        CamView.setDrawingCacheEnabled(false);

        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
        SaveAsync saveAsync = new SaveAsync();
        saveAsync.execute(bmp, object, imageFileName);

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

    static class SaveAsync extends AsyncTask<Object, Void, File> {

        IOnFileSaveSuccessFul iOnFileSaveSuccessFul;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected File doInBackground(Object... voids) {

            Bitmap bmp = (Bitmap) voids[0];
            Context context = (Context) voids[1];
            iOnFileSaveSuccessFul = (IOnFileSaveSuccessFul) (Context) voids[1];
            String imageFileName = (String) voids[2];

            File tmpFile = null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] bitmapdata = bos.toByteArray();
            ByteArrayInputStream fis2 = new ByteArrayInputStream(bitmapdata);


            //  storeBitmap(bmp, myfile);

            File dir_image = new File(Environment.getExternalStorageDirectory() + File.separator + "owl");
            dir_image.mkdirs();

            try {

                tmpFile = new File(dir_image, imageFileName);
                if (tmpFile.exists()) {
                    boolean isSuccess = tmpFile.delete();
                    Log.d("", "");
                }

                FileOutputStream fos = new FileOutputStream(tmpFile);

                byte[] buf = new byte[1024];
                int len;
                while ((len = fis2.read(buf)) > 0) {
                    fos.write(buf, 0, len);
                }
                fis2.close();

                fos.close();

                bmp.recycle();

            } catch (Exception e) {
                e.printStackTrace();
                iOnFileSaveSuccessFul.onFileSaveUnSuccessFull();
            }


            return tmpFile;
        }

        @Override
        protected void onPostExecute(File aVoid) {
            super.onPostExecute(aVoid);
            iOnFileSaveSuccessFul.onFileSaveSuccessFull(aVoid);
        }
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static float randFloat(float min, float max) {
        Random rand = new Random();
        float result = rand.nextFloat() * (max - min) + min;
        return result;
    }
}
