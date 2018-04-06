package com.insomniacs.photop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.insomniacs.photop.utils.AndroidUtils;
import com.insomniacs.photop.utils.CircleImageView;
import com.insomniacs.photop.utils.ContributorModel;

import java.util.ArrayList;

/**
 * Created by INSO18 on 05-04-2018.
 */

public class AdapterContribution extends RecyclerView.Adapter<AdapterContribution.MyViewHolder> {
    Context context;
    ArrayList<ContributorModel> datalist;

    public AdapterContribution(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ContributorModel> datalist) {
        this.datalist = datalist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_contribution, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ContributorModel contributorModel = datalist.get(position);
        AndroidUtils.setImageBackground(holder.circleImageView, contributorModel.resId);
        AndroidUtils.setText(holder.tvName, contributorModel.name);
        AndroidUtils.setText(holder.tvContributors, contributorModel.designation);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView tvName, tvContributors;

        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.civPicture);
            tvName = itemView.findViewById(R.id.tvName);
            tvContributors = itemView.findViewById(R.id.tvContributors);
        }
    }
}
