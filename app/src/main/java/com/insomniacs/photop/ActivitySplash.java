package com.insomniacs.photop;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;

import com.insomniacs.photop.utils.AndroidUtils;
import com.insomniacs.photop.utils.Util;

import java.util.ArrayList;

public class ActivitySplash extends AppCompatActivity {


    private static final int REQ_CODE_PERMISSION = 1001;
    ArrayList<ImageView> imageViews = new ArrayList<>();
    int animationViewsCompleted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ImageView img_an = findViewById(R.id.img_an);
        ImageView img_bd = findViewById(R.id.img_bd);
        ImageView img_rj = findViewById(R.id.img_rj);
        ImageView img_sop = findViewById(R.id.img_sop);
        ImageView img_sr = findViewById(R.id.img_sr);
        ImageView img_tss = findViewById(R.id.img_tss);
        ImageView img_sw = findViewById(R.id.img_sw);
        ImageView img_ts = findViewById(R.id.img_ts);
        imageViews.add(img_an);
        imageViews.add(img_bd);
        imageViews.add(img_rj);
        imageViews.add(img_sop);
        imageViews.add(img_sr);
        imageViews.add(img_tss);
        imageViews.add(img_sw);
        imageViews.add(img_ts);

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
                //checkForPermission();

                for (int i = 0; i < imageViews.size(); i++) {

                    Animation fadeIn1 = new AlphaAnimation(0, 1);
                    fadeIn1.setInterpolator(new AccelerateInterpolator());
                    fadeIn1.setDuration(Util.randInt(100, 2500));

                    final ImageView imageView = imageViews.get(i);
                    imageView.startAnimation(fadeIn1);
                    fadeIn1.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            imageView.setVisibility(View.VISIBLE);
                            synchronized (this) {
                                animationViewsCompleted++;
                                if (animationViewsCompleted == imageViews.size()) {
                                    checkForPermission();
                                }
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });


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
