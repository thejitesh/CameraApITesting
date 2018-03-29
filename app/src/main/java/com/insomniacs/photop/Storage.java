package com.insomniacs.photop;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by INSODROID1 on 29-03-2018.
 */

public class Storage {

    private static final String KEY_FILE_NUM_CONSTANT = "KEY_FILE_NUM_CONSTANT";

    private static SharedPreferences sharedPreferences;

    public static void init(Context context) {

        sharedPreferences = context.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        //Editor editor = pref.edit();
    }

    public static String getNextFileName() {

        int id = sharedPreferences.getInt(KEY_FILE_NUM_CONSTANT, 0);
        String strtToResturn = "opl_" + id + ".jpg";

        id++;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_FILE_NUM_CONSTANT, id);
        editor.apply();

        return strtToResturn;
    }

}
