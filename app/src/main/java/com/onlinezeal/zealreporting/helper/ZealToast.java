package com.onlinezeal.zealreporting.helper;

import android.widget.Toast;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public class ZealToast {

    public static Toast showToastWithMessage(String messageResourceId) {
        Toast toast = Toast.makeText(ZealApplication.getAppContext(), messageResourceId, Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

    public static Toast showLongToastWithMessage(String messageResourceId) {
        Toast toast = Toast.makeText(ZealApplication.getAppContext(), messageResourceId, Toast.LENGTH_LONG);
        toast.show();
        return toast;
    }

}
