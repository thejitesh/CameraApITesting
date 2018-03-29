package com.insomniacs.photop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by INSODROID1 on 27-03-2018.
 */

public class AdapterTeamLogoFrame extends RecyclerView.Adapter<AdapterTeamLogoFrame.Holder> {

    private Context context;
    private ArrayList<ModelTeamLogoFrame> logoFrames = new ArrayList<>();

    public AdapterTeamLogoFrame(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ModelTeamLogoFrame> logoFrames) {
        this.logoFrames = logoFrames;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_logo_frame, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        ModelTeamLogoFrame modelTeamLogoFrame = logoFrames.get(position);

    }

    @Override
    public int getItemCount() {
        return logoFrames.size();
    }

    class Holder extends RecyclerView.ViewHolder {



        public Holder(View itemView) {

            super(itemView);

        }
    }
}
