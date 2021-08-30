package com.ciesta.online.education.util;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public class BindingAdapters
{
    @BindingAdapter("app:errorText")
    public static void setErrorText(TextInputLayout layout, String errorText) {
        layout.setError(errorText);
    }

}
