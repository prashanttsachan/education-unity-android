package com.ciesta.online.education.screens.register;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ciesta.online.education.databinding.ActivityCreateUserBinding;
import com.ciesta.online.education.screens.SplashActivity;
import com.ciesta.online.education.screens.base.BaseActivity;
import com.ciesta.online.education.screens.home.HomeActivity;
import com.ciesta.online.education.screens.login.LoginActivity;

public class CreateUserActivity extends BaseActivity<ActivityCreateUserBinding> {
    @Override
    public ActivityCreateUserBinding inflate() {
        return ActivityCreateUserBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onBindingCreated() {

        CreateUserViewModel viewModel = new ViewModelProvider(this).get(CreateUserViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.getLaunchLoginActivity().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                startActivity(new Intent(CreateUserActivity.this, LoginActivity.class));
                finish();
            }
        });

        viewModel.getLaunchHomepage().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                startActivity(new Intent(CreateUserActivity.this, HomeActivity.class));
                finish();
            }
        });

    }

}