package com.insomniacs.photop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class ActivitySelfiePreview extends Activity {

    private static final String EXTRA_FILE_PATH = "EXTRA_FILE_PATH";
    private static final String EXTRA_MODEL_ID = "EXTRA_MODEL_ID";

    ImageView imgPreview;
    ImageView imgFrame;

    public static Intent getIntent(Context context, String path, String id) {

        Intent intent = new Intent(context, ActivitySelfiePreview.class);
        intent.putExtra(EXTRA_FILE_PATH, path);
        intent.putExtra(EXTRA_MODEL_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selfie_preview);

        imgPreview = findViewById(R.id.imgPreview);
        imgFrame = findViewById(R.id.imgFrame);
        Intent intent = getIntent();
        if (intent != null) {
            String path = intent.getStringExtra(EXTRA_FILE_PATH);
            String id = intent.getStringExtra(EXTRA_MODEL_ID);
            File file = new File(path);
            Picasso.get().load(file).into(imgPreview);

            ModelTeamLogoFrame modelTeamLogoFrame = LogoFramesFactory.getModelBasedOnId(id);
            Picasso.get().load(modelTeamLogoFrame.frameRes).into(imgFrame);

        }
    }
}
