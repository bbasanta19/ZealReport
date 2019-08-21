package com.onlinezeal.zealreporting.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public class UtilitiesFunctions {

    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

}
