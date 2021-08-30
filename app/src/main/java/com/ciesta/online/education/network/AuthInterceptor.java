package com.ciesta.online.education.network;

import com.ciesta.online.education.storage.CiestaPreference;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private CiestaPreference mPreference;

    public AuthInterceptor(CiestaPreference preference) {
        this.mPreference = preference;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.header("Content-Type", "application/json");
        builder.addHeader("Accept", "application/json");
        if(mPreference.getAuthToken() != null) {
            builder.addHeader("Authorization", "Bearer " + mPreference.getAuthToken());
        }
        return chain.proceed(builder.build());
    }
}
