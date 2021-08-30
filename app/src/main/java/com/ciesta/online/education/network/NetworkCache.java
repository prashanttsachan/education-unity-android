package com.ciesta.online.education.network;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;

public class NetworkCache {

    private static NetworkCache INSTANCE;
    private final Context mContext;

    private NetworkCache(Context context) {
        this.mContext = context;
    }

    public static void createInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new NetworkCache(context);
        }
    }

    public static NetworkCache getInstance() {
        return INSTANCE;
    }

    public Cache getCache() {
        return new Cache(new File(mContext.getCacheDir(), "default"), 10*10*1024);
    }
}
