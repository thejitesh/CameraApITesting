package com.insomniacs.photop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CameraPreviewSampleActivity extends Activity {
    private CameraPreview mPreview;
    private RelativeLayout mLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide status-bar
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hide title-bar, must be before setContentView
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Requires RelativeLayout.

        setContentView(R.layout.activity_preview);
        mLayout = findViewById(R.id.mLayout);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Util.TakeScreenshot(mPreview, CameraPreviewSampleActivity.this);
                mPreview.mCamera.takePicture(null, null, mPicture);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Set the second argument by your choice.
        // Usually, 0 for back-facing camera, 1 for front-facing camera.
        // If the OS is pre-gingerbreak, this does not have any effect.
        /*TODO change for camera type*/
        mPreview = new CameraPreview(this, 1, CameraPreview.LayoutMode.FitToParent);
        LayoutParams previewLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        // Un-comment below lines to specify the size.
        //previewLayoutParams.height = 500;
        //previewLayoutParams.width = 500;

        // Un-comment below line to specify the position.
        //mPreview.setCenterPosition(270, 130);

        mLayout.addView(mPreview, 0, previewLayoutParams);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPreview.stop();
        mLayout.removeView(mPreview); // This is necessary.
        mPreview = null;
    }


    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            MainActivity.setBitmapData(data);
            finish();
//            File dir_image2 = new File(Environment.getExternalStorageDirectory() + File.separator + "My Custom Folder");
//            dir_image2.mkdirs();
//
//            File tmpFile = new File(dir_image2, "TempImage.jpg");
//            try {
//                FileOutputStream fos = new FileOutputStream(tmpFile);
//                ByteArrayInputStream fis2 = new ByteArrayInputStream(data);
//
//                byte[] buf = new byte[1024];
//                int len;
//                while ((len = fis2.read(buf)) > 0) {
//                    fos.write(buf, 0, len);
//                }
//
//                fos.close();
//            } catch (FileNotFoundException e) {
//                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//            } catch (IOException e) {
//                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//            }
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//
//            Bitmap bmp1 = decodeFile(tmpFile);
//            Bitmap bmp = Bitmap.createScaledBitmap(bmp1, 1000, 100, true);
//            //  camera_image.setImageBitmap(bmp);
//            //Util.TakeScreenshot(mLayout , CameraPreviewSampleActivity.this);
//            //tmpFile.delete();
        }
    };


    public Bitmap decodeFile(File f) {
        Bitmap b = null;
        try {
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;

            FileInputStream fis = new FileInputStream(f);
            BitmapFactory.decodeStream(fis, null, o);
            fis.close();
            int IMAGE_MAX_SIZE = 1000;
            int scale = 1;
            if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
                scale = (int) Math.pow(
                        2,
                        (int) Math.round(Math.log(IMAGE_MAX_SIZE
                                / (double) Math.max(o.outHeight, o.outWidth))
                                / Math.log(0.5)));
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            fis = new FileInputStream(f);
            b = BitmapFactory.decodeStream(fis, null, o2);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return b;
    }

}
