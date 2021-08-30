package com.ciesta.online.education.screens.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<BindingType extends ViewDataBinding> extends AppCompatActivity {

    protected BindingType binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = inflate();
        setContentView(binding.getRoot());
        binding.setLifecycleOwner(this);
        onBindingCreated();
    }

    public abstract BindingType inflate();

    public abstract void onBindingCreated();
}
