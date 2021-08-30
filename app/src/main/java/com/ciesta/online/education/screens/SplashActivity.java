package com.ciesta.online.education.screens;

import android.content.Intent;
import android.os.Handler;

import com.ciesta.online.education.databinding.ActivitySplashBinding;
import com.ciesta.online.education.screens.base.BaseActivity;
import com.ciesta.online.education.screens.home.HomeActivity;
import com.ciesta.online.education.screens.login.LoginActivity;
import com.ciesta.online.education.storage.CiestaPreference;


public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    @Override
    public ActivitySplashBinding inflate() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onBindingCreated() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(CiestaPreference.getInstance().isUserAuthentication()) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, 1000);
    }
}