package com.onlinezeal.zealreporting.helper;

import android.support.v7.widget.RecyclerView;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public abstract class ZealRecyclerViewAdapter extends RecyclerView.Adapter {

    public abstract void add(Object object);
    public abstract void clear();
}
