package com.insomniacs.photop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class ActivitySelfiePreview extends Activity {

    private static final String EXTRA_FILE_PATH = "EXTRA_FILE_PATH";

    ImageView imgPreview;

    public static Intent getIntent(Context context, String path) {

        Intent intent = new Intent(context, ActivitySelfiePreview.class);
        intent.putExtra(EXTRA_FILE_PATH, path);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfie_preview);

        imgPreview = findViewById(R.id.imgPreview);
        Intent intent = getIntent();
        if (intent != null) {
            String path = intent.getStringExtra(EXTRA_FILE_PATH);
            File file = new File(path);
            Picasso.get().load(file).into(imgPreview);
        }
    }
}
