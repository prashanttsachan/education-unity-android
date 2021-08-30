package com.ciesta.online.education;

import android.app.Application;

import com.ciesta.online.education.network.NetworkCache;
import com.ciesta.online.education.storage.CiestaPreference;

public class CiestaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CiestaPreference.createInstance(this);
        NetworkCache.createInstance(this);
    }
}
