package com.onlinezeal.zealreporting.helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by BasantaBK on 19,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public class ZealApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private static ZealApplication zealApplication;
    private static SharedPreferences sharedPreferences;
    private static boolean isActive;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        zealApplication = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getAppContext());
    }

    public static boolean isActivityVisible() {
        return isActive;
    }

    public static Context getAppContext() {
        return zealApplication.getApplicationContext();
    }

    public static SharedPreferences getSharedPreference() {
        return sharedPreferences;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
