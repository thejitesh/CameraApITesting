package com.insomniacs.photop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zomato.photofilters.FilterPack;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.utils.ThumbnailCallback;
import com.zomato.photofilters.utils.ThumbnailItem;
import com.zomato.photofilters.utils.ThumbnailsManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActivityFrameEditPreview extends AppCompatActivity implements ThumbnailCallback {

    private static final String EXTRA_FILE_PATH = "EXTRA_FILE_PATH";
    private static final String EXTRA_MODEL_ID = "EXTRA_MODEL_ID";

    ImageView imgPreview;
    ImageView imgFrame;
    RecyclerView rvThumbnailsFilter;
    Bitmap bitmap;
    ImageView imgCross;

    static {
        System.loadLibrary("NativeImageProcessor");
    }

    public static Intent getIntent(Context context, String path, String id) {

        Intent intent = new Intent(context, ActivityFrameEditPreview.class);
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

        imgCross = findViewById(R.id.imgCross);
        imgPreview = findViewById(R.id.imgPreview);
        imgFrame = findViewById(R.id.imgFrame);
        rvThumbnailsFilter = findViewById(R.id.rvThumbnailsFilter);

        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThumbnailsManager.clearThumbs();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                finish();
            }
        });


        Intent intent = getIntent();
        if (intent != null) {

            String path = intent.getStringExtra(EXTRA_FILE_PATH);
            String id = intent.getStringExtra(EXTRA_MODEL_ID);

            File file = new File(path);
            Picasso.get().load(file).into(imgPreview);

            ModelTeamLogoFrame modelTeamLogoFrame = LogoFramesFactory.getModelBasedOnId(id);
            Picasso.get().load(modelTeamLogoFrame.frameRes).into(imgFrame);


            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), bmOptions);

            initHorizontalList();
        }
    }

    private void initHorizontalList() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        rvThumbnailsFilter.setLayoutManager(layoutManager);
        bindDataToAdapter();
    }

    private void bindDataToAdapter() {

        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {

                Bitmap thumbImage = Bitmap.createScaledBitmap(bitmap, 150, 150, false);
                ThumbnailsManager.clearThumbs();
                List<Filter> filters = FilterPack.getFilterPack(ActivityFrameEditPreview.this);

                for (Filter filter : filters) {
                    MyThumbnailItem thumbnailItem = new MyThumbnailItem();
                    thumbnailItem.image = thumbImage;
                    thumbnailItem.filter = filter;
                    //thumbnailItem.resId = R.drawable.girl_two;
                    ThumbnailsManager.addThumb(thumbnailItem);
                }

                List<ThumbnailItem> thumbs = ThumbnailsManager.processThumbs(ActivityFrameEditPreview.this);
                List<MyThumbnailItem> mythumbs = new ArrayList<>();
                for (ThumbnailItem thumbnailItem : thumbs) {
                    MyThumbnailItem myThumbnailItem = (MyThumbnailItem) thumbnailItem;
                    mythumbs.add(myThumbnailItem);
                }

                AdapterThumbnailsFilter adapter = new AdapterThumbnailsFilter(mythumbs, (ThumbnailCallback) ActivityFrameEditPreview.this);
                rvThumbnailsFilter.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }

    @Override
    public void onThumbnailClick(Filter filter) {

        // Bitmap first = BitmapFactory.decodeResource(getResources(), drawable);
        Bitmap second = Bitmap.createScaledBitmap(bitmap, 640, 640, false);
        //thumbImage.recycle();
        Bitmap third = filter.processFilter(second);
        //second.recycle();
        imgPreview.setImageBitmap(third);
        // placeHolderImageView.setImageBitmap(filter.processFilter(BitmapFactory.decodeResource(getResources(), drawable)));

        // third.recycle();
    }

}
