package com.ciesta.online.education.screens.login;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ciesta.online.education.databinding.ActivityLoginBinding;
import com.ciesta.online.education.screens.SplashActivity;
import com.ciesta.online.education.screens.base.BaseActivity;
import com.ciesta.online.education.screens.home.HomeActivity;
import com.ciesta.online.education.screens.register.CreateUserActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    @Override
    public ActivityLoginBinding inflate() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onBindingCreated() {
        LoginViewModel viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.getLaunchForgotPassword().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {

            }
        });

        viewModel.getLaunchRegisterUser().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                startActivity(new Intent(LoginActivity.this, CreateUserActivity.class));
                finish();
            }
        });

        viewModel.getLaunchHomepage().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}