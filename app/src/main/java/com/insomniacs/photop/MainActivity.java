package com.insomniacs.photop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout linearLayout;
    ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        Button b1 = (Button) findViewById(R.id.button_sample);
        b1.setOnClickListener(this);
        Button b2 = (Button) findViewById(R.id.button_test);
        b2.setOnClickListener(this);

        linearLayout = findViewById(R.id.llContainer);
        img = findViewById(R.id.img);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button_sample:
                intent = new Intent(this, ActivitySelfiePreview.class);
                startActivityForResult(intent, 10001);
//                Util.TakeScreenshot(linearLayout , MainActivity.this);
                break;
            case R.id.button_test:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    static Bitmap bmp;

    @Override
    protected void onResume() {
        super.onResume();

        if (bmp != null) {
            img.setImageBitmap(bmp);
        }

    }

    public static void setBitmapData(byte[] data) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        bmp = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        //Canvas canvas = new Canvas(bmp); // now it should work ok
    }
}
