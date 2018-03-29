package com.insomniacs.photop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by INSODROID1 on 27-03-2018.
 */

public class AdapterTeamLogoFrame extends RecyclerView.Adapter<AdapterTeamLogoFrame.Holder> {

    private Context context;
    private IOnFrameSelected iOnFrameSelected;
    private ArrayList<ModelTeamLogoFrame> logoFrames = new ArrayList<>();

    public AdapterTeamLogoFrame(Object object) {
        this.context = (Context) object;
        this.iOnFrameSelected = (IOnFrameSelected) object;
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

        final ModelTeamLogoFrame modelTeamLogoFrame = logoFrames.get(position);

        Picasso.get().load(modelTeamLogoFrame.teamAResId).into(holder.imgteamA);
        Picasso.get().load(modelTeamLogoFrame.teamBResId).into(holder.imgteamB);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnFrameSelected.onFrameSelected(modelTeamLogoFrame);
            }
        });

    }

    @Override
    public int getItemCount() {
        return logoFrames.size();
    }

    class Holder extends RecyclerView.ViewHolder {


        ImageView imgteamA;
        ImageView imgteamB;

        public Holder(View itemView) {

            super(itemView);
            imgteamA = (ImageView) itemView.findViewById(R.id.imgteamA);
            imgteamB = (ImageView) itemView.findViewById(R.id.imgteamB);
        }
    }
}
