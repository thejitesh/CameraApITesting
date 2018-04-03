package com.insomniacs.photop;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class ActivitySplash extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        runnable = new Runnable() {
            @Override
            public void run() {

                checkForPermission();
            }
        };
        handler = new Handler();
        handler.postDelayed(runnable, 3000);
    }

    private void checkForPermission() {

        ArrayList<String> persmissionsList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(ActivitySplash.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            persmissionsList.add(Manifest.permission.CAMERA);
        }
        if (ContextCompat.checkSelfPermission(ActivitySplash.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            persmissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (persmissionsList.isEmpty()) {
            startActivity(ActivityCameraPreview.getIntent(ActivitySplash.this));
        } else {
            String[] permissionsRequired = new String[persmissionsList.size()];
            for (int i = 0; i < persmissionsList.size(); i++) {
                permissionsRequired[i] = persmissionsList.get(i);
            }
            ActivityCompat.requestPermissions(ActivitySplash.this, permissionsRequired, 50);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 50) {
            checkForPermission();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}
