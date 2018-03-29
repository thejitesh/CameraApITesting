package com.insomniacs.photop;

import android.app.Application;

/**
 * Created by INSODROID1 on 29-03-2018.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Storage.init(this);
        LogoFramesFactory.setUp();

    }
}
