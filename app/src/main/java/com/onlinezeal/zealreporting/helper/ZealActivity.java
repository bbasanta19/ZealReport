package com.onlinezeal.zealreporting.helper;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public abstract class ZealActivity extends AppCompatActivity {
    abstract protected void initialiseViews();
    abstract protected void initialiseListener();

}
