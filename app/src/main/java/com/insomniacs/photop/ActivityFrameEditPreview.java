package com.insomniacs.photop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.insomniacs.photop.utils.BitmapUtils;
import com.insomniacs.photop.utils.Util;
import com.squareup.picasso.Picasso;
import com.zomato.photofilters.FilterPack;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.utils.ThumbnailCallback;
import com.zomato.photofilters.utils.ThumbnailItem;
import com.zomato.photofilters.utils.ThumbnailsManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActivityFrameEditPreview extends AppCompatActivity implements ThumbnailCallback, View.OnClickListener, IOnFileSaveSuccessFul {

    private static final String EXTRA_FILE_PATH = "EXTRA_FILE_PATH";
    private static final String EXTRA_MODEL_ID = "EXTRA_MODEL_ID";
    private static final String EXTRA_IS_FRONT_FACING = "EXTRA_IS_FRONT_FACING";

    ImageView imgPreview;
    ImageView imgFrame;
    RecyclerView rvThumbnailsFilter;
    Bitmap bitmap;
    RelativeLayout rlPreviewContainer;
    ProgressBar progressBar;
    String imageFileName;
    private boolean isFrontFacing;
    ModelTeamLogoFrame modelTeamLogoFrame;

    static {
        System.loadLibrary("NativeImageProcessor");
    }

    public static Intent getIntent(Context context, String path, String id, boolean isFrontFacing) {

        Intent intent = new Intent(context, ActivityFrameEditPreview.class);
        intent.putExtra(EXTRA_FILE_PATH, path);
        intent.putExtra(EXTRA_MODEL_ID, id);
        intent.putExtra(EXTRA_IS_FRONT_FACING, isFrontFacing);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selfie_preview);

        progressBar = findViewById(R.id.progressBar);
        imgPreview = findViewById(R.id.imgPreview);
        imgFrame = findViewById(R.id.imgFrame);
        rvThumbnailsFilter = findViewById(R.id.rvThumbnailsFilter);
        rlPreviewContainer = findViewById(R.id.rlPreviewContainer);
        ImageView imgCross = findViewById(R.id.imgCross);
        imgCross.setOnClickListener(this);
        TextView tvShare = findViewById(R.id.tvShare);
        tvShare.setOnClickListener(this);


        Intent intent = getIntent();
        if (intent != null) {

            String path = intent.getStringExtra(EXTRA_FILE_PATH);
            String id = intent.getStringExtra(EXTRA_MODEL_ID);
            isFrontFacing = intent.getBooleanExtra(EXTRA_IS_FRONT_FACING, false);


            File file = new File(path);
            modelTeamLogoFrame = LogoFramesFactory.getModelBasedOnId(id);
            Picasso.get().load(modelTeamLogoFrame.frameRes).into(imgFrame);
            switch (modelTeamLogoFrame.type) {
                case ModelTeamLogoFrame.TYPE_INDIVIDUAL_TEAM:
                case ModelTeamLogoFrame.TYPE_OWL:
                    imgFrame.getLayoutParams().height = (int) getResources().getDimension(R.dimen.user_selected_frame_height_individual);
                    break;

                case ModelTeamLogoFrame.TYPE_TWO_TEAMS:
                    imgFrame.getLayoutParams().height = (int) getResources().getDimension(R.dimen.user_selected_frame_height);
                    break;
            }
            imgFrame.requestLayout();


            Bitmap bitmapDecoded = BitmapFactory.decodeFile(file.getAbsolutePath());

            if (isFrontFacing) {
                Bitmap bitmapRoated = ExifUtil.rotateBitmap(file.getAbsolutePath(), bitmapDecoded);
                bitmap = BitmapUtils.fixMirrorImage(bitmapRoated);
            } else {
                bitmap = ExifUtil.rotateBitmap(file.getAbsolutePath(), bitmapDecoded);
            }

            imgPreview.setImageBitmap(bitmap);
            initHorizontalList();

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ActivityFrameEditPreview.this);
            int nu = preferences.getInt("image_num", 0);
            nu++;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("image_num", nu);
            editor.apply();
            String picId = String.valueOf(nu);
            imageFileName = "MyImage" + picId + ".jpeg";

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
        Bitmap second = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
        //thumbImage.recycle();

        if (!second.isMutable()) {
            Bitmap mutable = second.copy(Bitmap.Config.ARGB_8888, true);
            Bitmap third = filter.processFilter(mutable);
            imgPreview.setImageBitmap(third);
        } else {
            Bitmap third = filter.processFilter(second);
            imgPreview.setImageBitmap(third);
        }

        // placeHolderImageView.setImageBitmap(filter.processFilter(BitmapFactory.decodeResource(getResources(), drawable)));

        // third.recycle();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imgCross:
                ThumbnailsManager.clearThumbs();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                finish();
                break;

            case R.id.tvShare:

                Util.TakeScreenshot(progressBar, rlPreviewContainer, this, imageFileName);
                break;
        }
    }

    public void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFileSaveSuccessFull(File file) {

        hideLoader();


        String sharableText = "";
        switch (modelTeamLogoFrame.type) {
            case ModelTeamLogoFrame.TYPE_INDIVIDUAL_TEAM:
                sharableText = "I am here to support the " + modelTeamLogoFrame.teamAName + " in Owl Warrior League Season1. Cheers!  #OWL #OwlWarriorLeague #" + modelTeamLogoFrame.teamANameNoSpace;
                break;

            case ModelTeamLogoFrame.TYPE_TWO_TEAMS:
                sharableText = "The temperature is soaring here at Owl Warrior League. It's Fun and Masti all around. #OWL #OwlWarriorLeague #"
                        + modelTeamLogoFrame.teamANameNoSpace + "vs" + modelTeamLogoFrame.teamBNameNoSpace + " " + modelTeamLogoFrame.teamAHashTag + " " + modelTeamLogoFrame.teamBHashTag;
                break;

            case ModelTeamLogoFrame.TYPE_OWL:
                sharableText = "I am at OWL Season 1! #OWL #OwlWarriorLeague";
                break;
        }

        Uri imageUri = Uri.fromFile(file);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, sharableText);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        Uri apkURI = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", file);
        shareIntent.setDataAndType(apkURI, "image/jpeg");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        startActivity(Intent.createChooser(shareIntent, "POST"));

    }

    @Override
    public void onFileSaveUnSuccessFull() {

        Toast.makeText(this, "Shairing Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bitmap != null) {
            bitmap.recycle();
        }
    }
}
