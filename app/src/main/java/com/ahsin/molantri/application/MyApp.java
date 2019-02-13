package com.ahsin.molantri.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);

        AndroidNetworking.initialize(this);
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);

    }

}
