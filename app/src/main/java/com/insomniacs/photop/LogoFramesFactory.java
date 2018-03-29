package com.insomniacs.photop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by INSODROID1 on 29-03-2018.
 */

public class LogoFramesFactory {

    private static ArrayList<ModelTeamLogoFrame> modelTeamLogoFrames = new ArrayList<>();
    private static HashMap<String, ModelTeamLogoFrame> hmPairModelTeamLogo = new HashMap<>();

    public static void setUp() {

        modelTeamLogoFrames.add(new ModelTeamLogoFrame("1", "Sons Of Pitches", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("2", "Sons Of Pitches", " Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("3", "Sons Of Pitches", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("4", "Sons Of Pitches", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("5", "Sons Of Pitches", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("6", "Sons Of Pitches", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("7", "Sons Of Pitches", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));

        for (ModelTeamLogoFrame modelTeamLogoFrame : modelTeamLogoFrames) {
            hmPairModelTeamLogo.put(modelTeamLogoFrame.id, modelTeamLogoFrame);
        }
    }

    public static ModelTeamLogoFrame getModelBasedOnId(String id) {
        return hmPairModelTeamLogo.get(id);
    }

    public static ArrayList<ModelTeamLogoFrame> getList() {
        return modelTeamLogoFrames;
    }

}
