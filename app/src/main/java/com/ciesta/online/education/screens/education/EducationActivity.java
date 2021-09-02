package com.ciesta.online.education.screens.education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.ciesta.online.education.R;

public class EducationActivity extends AppCompatActivity {

    private EducationViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        mViewModel = new ViewModelProvider(this).get(EducationViewModel.class);
    }

}