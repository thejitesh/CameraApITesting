package com.insomniacs.photop;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zomato.photofilters.utils.ThumbnailCallback;

import java.util.List;


/**
 * Created by INSO18 on 29-03-2018.
 */

public class AdapterThumbnailsFilter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "THUMBNAILS_ADAPTER";
    private static int lastPosition = -1;
    private ThumbnailCallback thumbnailCallback;
    private List<MyThumbnailItem> dataSet;

    public AdapterThumbnailsFilter(List<MyThumbnailItem> dataSet, ThumbnailCallback thumbnailCallback) {
        Log.v(TAG, "Thumbnails Adapter has " + dataSet.size() + " items");
        this.dataSet = dataSet;
        this.thumbnailCallback = thumbnailCallback;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_thumbnail_filter, viewGroup, false);
        return new ThumbnailsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {

        final MyThumbnailItem thumbnailItem = dataSet.get(i);
        ThumbnailsViewHolder thumbnailsViewHolder = (ThumbnailsViewHolder) holder;
        thumbnailsViewHolder.thumbnail.setImageBitmap(thumbnailItem.image);
        try {
            thumbnailsViewHolder.filterName.setText(thumbnailItem.filter.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setAnimation(thumbnailsViewHolder.thumbnail, i);
        thumbnailsViewHolder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastPosition != i) {
                    thumbnailCallback.onThumbnailClick(thumbnailItem.filter);
                    lastPosition = i;
                }
            }

        });
    }

    private void setAnimation(View viewToAnimate, int position) {

//            ViewHelper.setAlpha(viewToAnimate, .0f);
//            com.nineoldandroids.view.ViewPropertyAnimator.animate(viewToAnimate).alpha(1).setDuration(50).start();
//            lastPosition = position;

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ThumbnailsViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView filterName;

        public ThumbnailsViewHolder(View v) {
            super(v);
            this.thumbnail = (ImageView) v.findViewById(R.id.thumbnail);
            this.filterName = (TextView) v.findViewById(R.id.filterName);
        }
    }
}
