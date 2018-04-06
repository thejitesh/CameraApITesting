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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.insomniacs.photop.utils.AndroidUtils;
import com.insomniacs.photop.utils.Util;

import java.util.ArrayList;

public class ActivitySplash extends AppCompatActivity {

    private static final int REQ_CODE_PERMISSION = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateDecelerateInterpolator()); //add this
        fadeIn.setDuration(3000);

        ImageView imgOwl = findViewById(R.id.imgOwl);
        imgOwl.startAnimation(fadeIn);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                checkForPermission();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        AndroidUtils.printDensityType(this);

    }

    private void checkForPermission() {

        ArrayList<String> permissionsList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(ActivitySplash.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(Manifest.permission.CAMERA);
        }
        if (ContextCompat.checkSelfPermission(ActivitySplash.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (permissionsList.isEmpty()) {
            finish();
            startActivity(ActivityCameraPreview.getIntent(ActivitySplash.this));
        } else {
            String[] permissionsRequired = new String[permissionsList.size()];
            for (int i = 0; i < permissionsList.size(); i++) {
                permissionsRequired[i] = permissionsList.get(i);
            }
            ActivityCompat.requestPermissions(ActivitySplash.this, permissionsRequired, REQ_CODE_PERMISSION);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_CODE_PERMISSION) {
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
