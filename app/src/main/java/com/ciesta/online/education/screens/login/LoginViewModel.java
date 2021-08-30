package com.ciesta.online.education.screens.login;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ciesta.online.education.model.request.LoginRequest;
import com.ciesta.online.education.model.response.ApiResponse;
import com.ciesta.online.education.model.response.LoginData;
import com.ciesta.online.education.network.RetrofitClient;
import com.ciesta.online.education.storage.CiestaPreference;
import com.ciesta.online.education.util.Validation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> userNameError = new MutableLiveData<>();
    public MutableLiveData<String> passwordError = new MutableLiveData<>();

    private final MutableLiveData<Object> launchForgotPassword = new MutableLiveData<>();
    public LiveData<Object> getLaunchForgotPassword() {
        return launchForgotPassword;
    }

    private final MutableLiveData<Object> launchRegisterUser = new MutableLiveData<>();
    public LiveData<Object> getLaunchRegisterUser() {
        return launchRegisterUser;
    }

    private final MutableLiveData<Object> launchHomepage = new MutableLiveData<>();
    public LiveData<Object> getLaunchHomepage() {
        return launchHomepage;
    }

    private final RetrofitClient mClient;

    public LoginViewModel() {
        mClient = RetrofitClient.getInstance();
    }

    public void onLoginClick() {
        if (username.getValue() == null || username.getValue() != null && username.getValue().trim().isEmpty()) {
            userNameError.setValue("Please Enter Mobile Number/ Email.");
            return;
        }
        if (password.getValue() == null || password.getValue() != null && password.getValue().trim().isEmpty()) {
            passwordError.setValue("Please Enter Password.");
            return;
        }

        if (!Validation.isValidUserName(username.getValue())) {
            userNameError.setValue("Please Enter Valid Mobile Number/Email.\nEx: 9988776655/xyz@abc.com");
            return;
        }

        String email = null;
        String mobile = null;

        if (Validation.isValidEmail(username.getValue()))
            email = username.getValue().trim();
        else if (Validation.isValidPhoneNumber(username.getValue()))
            mobile = username.getValue().trim();

        LoginRequest request = new LoginRequest(mobile, email, password.getValue().trim());

        mClient.getApi().userLogin(request).enqueue(new Callback<ApiResponse<LoginData>>() {
            @Override
            public void onResponse(Call<ApiResponse<LoginData>> call, Response<ApiResponse<LoginData>> response) {
                if(response.isSuccessful() && response.body().getData() != null) {
                    LoginData data = response.body().getData();
                    if(data.isAuthenticate()) {
                        CiestaPreference.getInstance().setAuthToken(data.getAccessToken());
                        CiestaPreference.getInstance().setUserAuthentication(data.isAuthenticate());

                        launchHomepage.setValue(new Object());
                    } else {
                        // Show error
                    }
                } else if(response.isSuccessful() && response.body().getError() != null)  {

                } else {

                }
            }

            @Override
            public void onFailure(Call<ApiResponse<LoginData>> call, Throwable throwable) {
                Log.e("Login Error", throwable.getLocalizedMessage());
            }
        });
    }

    public void onCreateUserAccount() {
        launchRegisterUser.setValue(new Object());
    }

    public void onForgotPasswordClick() {
        launchForgotPassword.setValue(new Object());
    }

}
