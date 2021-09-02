package com.ciesta.online.education.screens.donation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ciesta.online.education.R;

public class DonationActivity extends AppCompatActivity {

    private DonationViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        mViewModel = new ViewModelProvider(this).get(DonationViewModel.class);
    }

}