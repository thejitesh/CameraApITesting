package com.insomniacs.photop;

/**
 * @author Jose Davis Nidhin
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActivityCameraPreview extends AppCompatActivity implements IOnFrameSelected {

    private static final String TAG = "ActivityCameraPreview";
    private Preview preview;
    private Camera camera;
    private ImageView imgFragmeImage;
    private ModelTeamLogoFrame currModelTeamLogoFrame;


    public static Intent getIntent(Context context) {

        Intent intent = new Intent(context, ActivityCameraPreview.class);
        return intent;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_two);

        imgFragmeImage = findViewById(R.id.imgFragmeImage);
        preview = new Preview(this, (SurfaceView) findViewById(R.id.surfaceView));
        preview.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        FrameLayout frameLayout = findViewById(R.id.layout);
        frameLayout.addView(preview);
        preview.setKeepScreenOn(true);

        preview.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean arg0, Camera arg1) {

                        if (currModelTeamLogoFrame == null) {
                            Toast.makeText(ActivityCameraPreview.this, "Select Frame", Toast.LENGTH_SHORT).show();
                            return;
                        }


                        camera.takePicture(shutterCallback, rawCallback, jpegCallback);
                    }
                });
            }
        });

        RecyclerView rvFrames = findViewById(R.id.rvFrames);
        AdapterTeamLogoFrame adapterTeamLogoFrame = new AdapterTeamLogoFrame(this);
        rvFrames.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvFrames.setAdapter(adapterTeamLogoFrame);
        adapterTeamLogoFrame.setData(LogoFramesFactory.getList());
    }

    @Override
    protected void onResume() {

        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 50);
        } else {
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 50) {
            openCamera();
        }
    }

    private void openCamera() {

        if (camera != null) {
            return;
        }
        int numCams = Camera.getNumberOfCameras();
        if (numCams > 0) {
            try {
                camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);
                camera.startPreview();
                preview.setCamera(camera);

            } catch (RuntimeException ex) {
                Toast.makeText(this, getString(R.string.camera_not_found), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onPause() {

        stopCameraPreview();
        super.onPause();
    }

    private void stopCameraPreview() {

        if (camera != null) {
            camera.stopPreview();
            preview.setCamera(null);
            camera.release();
            camera = null;
        }
    }

    private void resetCam() {

        camera.startPreview();
        preview.setCamera(camera);
    }

    private void refreshGallery(File file) {

        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.fromFile(file));
        sendBroadcast(mediaScanIntent);
    }

    ShutterCallback shutterCallback = new ShutterCallback() {
        public void onShutter() {
            //			 Log.d(TAG, "onShutter'd");
        }
    };

    PictureCallback rawCallback = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            //			 Log.d(TAG, "onPictureTaken - raw");
        }
    };

    PictureCallback jpegCallback = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {

            new SaveImageTask().execute(data);
            //resetCam();
            stopCameraPreview();
            //Log.d(TAG, "onPictureTaken - jpeg");
        }
    };

    @Override
    public void onFrameSelected(ModelTeamLogoFrame modelTeamLogoFrame) {

        currModelTeamLogoFrame = modelTeamLogoFrame;
        Picasso.get().load(modelTeamLogoFrame.frameRes).into(imgFragmeImage);

    }

    private class SaveImageTask extends AsyncTask<byte[], Void, File> {

        @Override
        protected File doInBackground(byte[]... data) {
            FileOutputStream outStream = null;

            // Write to SD Card
            try {
                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + "/owl");
                dir.mkdirs();

                File outFile = new File(dir, Storage.getNextFileName());

                outStream = new FileOutputStream(outFile);
                outStream.write(data[0]);
                outStream.flush();
                outStream.close();
                refreshGallery(outFile);
                return outFile;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
            return null;
        }

        @Override
        protected void onPostExecute(File aVoid) {

            super.onPostExecute(aVoid);
//            Bitmap bitmap = BitmapFactory.decodeFile(aVoid.getAbsolutePath());
//            Bitmap bb = ExifUtil.rotateBitmap(aVoid.getAbsolutePath(), bitmap);
//
//            image.setVisibility(View.VISIBLE);
//            image.setBitmap(bb);

            startActivity(ActivityFrameEditPreview.getIntent(ActivityCameraPreview.this, aVoid.getAbsolutePath(), currModelTeamLogoFrame != null ? currModelTeamLogoFrame.id : ""));
        }
    }
}


