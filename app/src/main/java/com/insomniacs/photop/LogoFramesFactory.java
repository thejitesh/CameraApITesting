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

        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "The Scorpion Squad", R.drawable.frame_sop_tss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", " Tandava Strotam", R.drawable.frame_sop_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Anonymous", R.drawable.frame_sop_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Scoring Willows", R.drawable.frame_sop_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Royal Jatts", R.drawable.frame_sop_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Beer Dose", R.drawable.frame_sop_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Sleepless Rangers", R.drawable.frame_sop_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Sons Of Pitches", R.drawable.frame_tss_sop, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", " Tandava Strotam", R.drawable.frame_tss_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Anonymous", R.drawable.frame_tss_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Scoring Willows", R.drawable.frame_tss_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Royal Jatts", R.drawable.frame_tss_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Beer Dose", R.drawable.frame_tss_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Sleepless Rangers", R.drawable.frame_tss_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "The Scorpion Squad", R.drawable.frame_ts_tss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Sons Of Pitches", R.drawable.frame_ts_sop, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Anonymous", R.drawable.frame_tss_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Scoring Willows", R.drawable.frame_tss_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Royal Jatts", R.drawable.frame_tss_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Beer Dose", R.drawable.frame_tss_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Sleepless Rangers", R.drawable.frame_tss_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "The Scorpion Squad", R.drawable.frame_an_sop, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Tandava Strotam", R.drawable.frame_an_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Sons Of Pitches", R.drawable.frame_an_sop, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Scoring Willows", R.drawable.frame_an_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Royal Jatts", R.drawable.frame_an_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Beer Dose", R.drawable.frame_an_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Sleepless Rangers", R.drawable.frame_an_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "The Scorpion Squad", R.drawable.frame_sw_tss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", " Tandava Strotam", R.drawable.frame_sw_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Anonymous", R.drawable.frame_sw_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Sons Of Pitches", R.drawable.frame_sw_sop, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Royal Jatts", R.drawable.frame_sw_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Beer Dose", R.drawable.frame_sw_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Sleepless Rangers", R.drawable.frame_sw_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "The Scorpion Squad", R.drawable.frame_rj_tss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Tandava Strotam", R.drawable.frame_rj_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Anonymous", R.drawable.frame_rj_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Scoring Willows", R.drawable.frame_rj_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Sons Of Pitches", R.drawable.frame_rj_sop, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Beer Dose", R.drawable.frame_rj_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Sleepless Rangers", R.drawable.frame_rj_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "The Scorpion Squad", R.drawable.frame_bd_tss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", " Tandava Strotam", R.drawable.frame_bd_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Anonymous", R.drawable.frame_bd_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Scoring Willows", R.drawable.frame_bd_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Royal Jatts", R.drawable.frame_bd_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Sons Of Pitches", R.drawable.frame_bd_sop, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Sleepless Rangers", R.drawable.frame_bd_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "The Scorpion Squad", R.drawable.frame_sr_tss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Tandava Strotam", R.drawable.frame_sr_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Anonymous", R.drawable.frame_sr_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Sons Of Pitches", R.drawable.frame_sr_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Royal Jatts", R.drawable.frame_sr_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Beer Dose", R.drawable.frame_sr_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Sons Of Pitches", R.drawable.frame_sr_sop, R.drawable.team_sop, R.drawable.team_sr));


        int idCounter = 1;
        for (int i = 0; i < modelTeamLogoFrames.size(); i++) {
            ModelTeamLogoFrame modelTeamLogoFrame = modelTeamLogoFrames.get(i);
            modelTeamLogoFrame.id = String.valueOf(idCounter);
            idCounter++;
            modelTeamLogoFrame.type = ModelTeamLogoFrame.TYPE_TWO_TEAMS;
            hmPairModelTeamLogo.put(modelTeamLogoFrame.id, modelTeamLogoFrame);
        }

        ArrayList<ModelTeamLogoFrame> modelTeamLogoFramesOnlyTeams = new ArrayList<>();


        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("The Scorpion Squad", "", R.drawable.frame_tss, R.drawable.team_ss, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Tandava Strotam", "", R.drawable.frame_ts, R.drawable.team_ts, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Anonymous", "", R.drawable.frame_an, R.drawable.team_an, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Scoring Willows", "", R.drawable.frame_sw, R.drawable.team_sw, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Royal Jatts", "", R.drawable.frame_rj, R.drawable.team_rj, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Beer Dose", "", R.drawable.frame_bd, R.drawable.team_bd, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Sleepless Rangers", "", R.drawable.frame_sr, R.drawable.team_sr, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Sons Of Pitches", "", R.drawable.frame_sop, R.drawable.team_sop, R.drawable.team_ss));

        for (int i = 0; i < modelTeamLogoFramesOnlyTeams.size(); i++) {
            ModelTeamLogoFrame modelTeamLogoFrame = modelTeamLogoFramesOnlyTeams.get(i);
            modelTeamLogoFrame.id = String.valueOf(idCounter);
            idCounter++;
            modelTeamLogoFrame.type = ModelTeamLogoFrame.TYPE_INDIVIDUAL_TEAM;
            modelTeamLogoFrames.add(0, modelTeamLogoFrame);
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
