package com.ciesta.online.education.storage;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

public class CiestaPreference {

    private static final String PREF_NAME = "ciesta_online_educational_pref";
    private static final String AUTH_TOKEN = "auth_token";
    private static final String USER_NAME = "name";
    private static final String USER_EMAIL = "email";
    private static final String USER_MOBILE_NO = "mobile";
    private static final String USER_AUTHENTICATION = "authenticated";

    private static CiestaPreference INSTANCE;
    private final SharedPreferences sPreferences;

    private CiestaPreference(Context context) {
        sPreferences = context.getSharedPreferences(PREF_NAME,0);
    }

    public static CiestaPreference getInstance() {
        return INSTANCE;
    }

    public static void createInstance(@Nullable Context context) {
        if(INSTANCE == null) {
            INSTANCE = new CiestaPreference(context);
        }
    }

    public void setAuthToken(String authToken) {
        sPreferences.edit().putString(AUTH_TOKEN, authToken).apply();
    }

    public String getAuthToken() {
        return sPreferences.getString(AUTH_TOKEN, null);
    }

    public void setUserAuthentication(boolean authenticate) {
        sPreferences.edit().putBoolean(USER_AUTHENTICATION, authenticate).apply();
    }

    public boolean isUserAuthentication() {
        return sPreferences.getBoolean(USER_AUTHENTICATION, false);
    }
}
