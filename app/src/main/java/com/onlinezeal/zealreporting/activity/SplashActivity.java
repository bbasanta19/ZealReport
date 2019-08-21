package com.onlinezeal.zealreporting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.onlinezeal.zealreporting.R;
import com.onlinezeal.zealreporting.helper.ZealActivity;
import com.onlinezeal.zealreporting.utils.Utilities;

/**
 * Created by BasantaBK on 20,Aug,2019.
 * Copyright (c) 2019. OnlineZeal Pvt. Ltd.
 * basantabk19@gmail.com
 **/

public class SplashActivity extends ZealActivity {

    // Splash screen timer
    private int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initialiseViews();
        initialiseListener();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Utilities.isLogin()) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void initialiseViews() {

    }

    @Override
    protected void initialiseListener() {

    }
}
