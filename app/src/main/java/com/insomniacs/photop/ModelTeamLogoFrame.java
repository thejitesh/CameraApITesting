package com.insomniacs.photop;

/**
 * Created by INSODROID1 on 27-03-2018.
 */

public class ModelTeamLogoFrame {

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
