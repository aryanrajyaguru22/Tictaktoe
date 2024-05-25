package com.example.tictaktoe;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class metrialyou extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
