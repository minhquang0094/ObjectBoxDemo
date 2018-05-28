package com.example.minhquang.objectboxdemo;

import android.annotation.SuppressLint;
import android.app.Application;

import com.example.minhquang.objectboxdemo.Models.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.BoxStoreBuilder;

public class App extends Application {
    private static App app;
    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }

    public static App getApp() {
        return app;
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
