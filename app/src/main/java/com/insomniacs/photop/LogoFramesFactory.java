package com.insomniacs.photop;

import java.util.ArrayList;

/**
 * Created by INSODROID1 on 29-03-2018.
 */

public class LogoFramesFactory {

    public static ArrayList<ModelTeamLogoFrame> getList() {

        ArrayList<ModelTeamLogoFrame> modelTeamLogoFrames = new ArrayList<>();

        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", " Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));

        return modelTeamLogoFrames;
    }

}
