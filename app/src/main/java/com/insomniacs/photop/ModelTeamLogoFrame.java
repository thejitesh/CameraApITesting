package com.insomniacs.photop;

/**
 * Created by INSODROID1 on 27-03-2018.
 */

public class ModelTeamLogoFrame {

    public final static int TYPE_INDIVIDUAL_TEAM = 101;
    public final static int TYPE_TWO_TEAMS = 102;

    int type;
    String id;
    String teamAName;
    String teamBName;
    int frameRes;
    int teamAResId;
    int teamBResId;
    String teamAHashTag;
    String teamBHashTag;

    public ModelTeamLogoFrame(String teamAName,
                              String teamBName,
                              int frameRes,
                              int teamAResId,
                              int teamBResId,
                              String teamAHashTag,
                              String teamBHashTag) {

        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.teamAResId = teamAResId;
        this.teamBResId = teamBResId;
        this.frameRes = frameRes;
        this.teamAHashTag = teamAHashTag;
        this.teamBHashTag = teamBHashTag;
    }
}
