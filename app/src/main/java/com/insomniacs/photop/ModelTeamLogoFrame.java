package com.insomniacs.photop;

/**
 * Created by INSODROID1 on 27-03-2018.
 */

public class ModelTeamLogoFrame {

    public static int TYPE_INDIVIDUAL_TEAM = 101;
    public static int TYPE_TWO_TEAMS = 102;

    int type;
    String id;
    String teamAName;
    String teamBName;
    int frameRes;
    int teamAResId;
    int teamBResId;

    public ModelTeamLogoFrame(String teamAName,
                              String teamBName,
                              int frameRes,
                              int teamAResId,
                              int teamBResId) {

        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamAResId = teamAResId;
        this.teamBResId = teamBResId;
        this.frameRes = frameRes;
    }
}
