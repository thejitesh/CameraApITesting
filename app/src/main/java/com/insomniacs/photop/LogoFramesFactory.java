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

        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", " Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sons Of Pitches", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Sons Of Pitches", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", " Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("The Scorpion Squad", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Sons Of Pitches", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Tandava Strotam", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Sons Of Pitches", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Anonymous", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", " Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Sons Of Pitches", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Scoring Willows", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Sons Of Pitches", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Royal Jatts", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", " Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Scoring Willows", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Sons Of Pitches", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Beer Dose", "Sleepless Rangers", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "The Scorpion Squad", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Tandava Strotam", R.drawable.frame_ssp_ts, R.drawable.team_sop, R.drawable.team_ts));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Anonymous", R.drawable.frame_ssp_an, R.drawable.team_sop, R.drawable.team_an));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Sons Of Pitches", R.drawable.frame_ssp_sw, R.drawable.team_sop, R.drawable.team_sw));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Royal Jatts", R.drawable.frame_ssp_rj, R.drawable.team_sop, R.drawable.team_rj));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Beer Dose", R.drawable.frame_ssp_bd, R.drawable.team_sop, R.drawable.team_bd));
        modelTeamLogoFrames.add(new ModelTeamLogoFrame("Sleepless Rangers", "Sons Of Pitches", R.drawable.frame_ssp_sr, R.drawable.team_sop, R.drawable.team_sr));


        int idCounter = 1;
        for (int i = 0; i < modelTeamLogoFrames.size(); i++) {
            ModelTeamLogoFrame modelTeamLogoFrame = modelTeamLogoFrames.get(i);
            modelTeamLogoFrame.id = String.valueOf(idCounter);
            idCounter++;
            modelTeamLogoFrame.type = ModelTeamLogoFrame.TYPE_TWO_TEAMS;
            hmPairModelTeamLogo.put(modelTeamLogoFrame.id, modelTeamLogoFrame);
        }

        ArrayList<ModelTeamLogoFrame> modelTeamLogoFramesOnlyTeams = new ArrayList<>();


        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("The Scorpion Squad", "", R.drawable.frame_ssp_ss, R.drawable.team_ss, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Tandava Strotam", "", R.drawable.frame_ssp_ss, R.drawable.team_ts, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Anonymous", "", R.drawable.frame_ssp_ss, R.drawable.team_an, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Scoring Willows", "", R.drawable.frame_ssp_ss, R.drawable.team_sw, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Royal Jatts", "", R.drawable.frame_ssp_ss, R.drawable.team_rj, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Beer Dose", "", R.drawable.frame_ssp_ss, R.drawable.team_bd, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Sleepless Rangers", "", R.drawable.frame_ssp_ss, R.drawable.team_sr, R.drawable.team_ss));
        modelTeamLogoFramesOnlyTeams.add(new ModelTeamLogoFrame("Sons Of Pitches", "", R.drawable.frame_ssp_ss, R.drawable.team_sop, R.drawable.team_ss));

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
