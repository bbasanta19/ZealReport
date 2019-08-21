package com.onlinezeal.zealreporting.utils;

import android.content.SharedPreferences;
import com.onlinezeal.zealreporting.constants.AppConstants;
import static com.onlinezeal.zealreporting.helper.ZealApplication.getSharedPreference;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public class Utilities {

    /*
     * SHARED PREFERENCES UTILITIES
     * */

    public static void setFirstLogin(boolean status) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putBoolean(AppConstants.IS_FIRST_LOGIN, status);
        editor.apply();
    }

    public static boolean isLogin() {
        boolean isLogin = getSharedPreference().getBoolean(AppConstants.IS_FIRST_LOGIN, false);
        return isLogin;
    }

    public static boolean isFirstRun() {
        boolean isFirstRun = getSharedPreference().getBoolean(AppConstants.IS_FIRST_RUN, false);
        return isFirstRun;
    }

    public static void setFirstRunCompleted() {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putBoolean(AppConstants.IS_FIRST_RUN, true);
        editor.apply();
    }

    /*public static Login getLoginResponse() {
        String savedUserResponse = getSharedPreference().getString(AppConstants.LOGIN_RESPONSE, null);
        return new GsonBuilder().create().fromJson(savedUserResponse, Login.class);
    }

    public static void saveLoginResponse(Login loginResponse) {
        //Log.e("saveLoginResponse AAA", new GsonBuilder().create().toJson(loginResponse));
        String json = new GsonBuilder().create().toJson(loginResponse);
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putString(AppConstants.LOGIN_RESPONSE, json);
        editor.apply();
    }*/
}
