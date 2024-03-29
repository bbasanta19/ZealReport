package com.onlinezeal.zealreporting.helper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public abstract class ZealFragment extends android.support.v4.app.Fragment {

    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    abstract protected void initialiseView(View view);
    abstract protected void initialiseListeners();
}
