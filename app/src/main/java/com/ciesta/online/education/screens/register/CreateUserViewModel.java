package com.ciesta.online.education.screens.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ciesta.online.education.model.request.CreateUserRequest;
import com.ciesta.online.education.model.response.ApiResponse;
import com.ciesta.online.education.model.response.LoginData;
import com.ciesta.online.education.network.RetrofitClient;
import com.ciesta.online.education.storage.CiestaPreference;
import com.ciesta.online.education.util.Validation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserViewModel extends ViewModel {

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> mobileNo = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> profession = new MutableLiveData<>();
    public MutableLiveData<String> userNameError = new MutableLiveData<>();
    public MutableLiveData<String> emailError = new MutableLiveData<>();
    public MutableLiveData<String> mobileNoError = new MutableLiveData<>();
    public MutableLiveData<String> passwordError = new MutableLiveData<>();
    public MutableLiveData<String> professionError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isProgressEnabled = new MutableLiveData<>(false);

    private final MutableLiveData<Object> launchLoginActivity = new MutableLiveData<>();
    public LiveData<Object> getLaunchLoginActivity() {
        return launchLoginActivity;
    }

    private final MutableLiveData<Object> launchHomepage = new MutableLiveData<>();
    public LiveData<Object> getLaunchHomepage() {
        return launchHomepage;
    }

    private final RetrofitClient mClient;

    public CreateUserViewModel() {
        mClient = RetrofitClient.getInstance();
    }

    public void onRegisterClick() {

        if (username.getValue() == null || username.getValue() != null && username.getValue().trim().isEmpty()) {
            userNameError.setValue("Please Enter Email.");
            return;
        }

        if (email.getValue() == null || email.getValue() != null && email.getValue().trim().isEmpty()) {
            emailError.setValue("Please Enter Email.");
            return;
        }

        if (mobileNo.getValue() == null || mobileNo.getValue() != null && mobileNo.getValue().trim().isEmpty()) {
            mobileNoError.setValue("Please Enter MobileNo.");
            return;
        }
        if (password.getValue() == null || password.getValue() != null && password.getValue().trim().isEmpty()) {
            passwordError.setValue("Please Enter Password.");
            return;
        }
        if (profession.getValue() == null || profession.getValue() != null && profession.getValue().trim().isEmpty()) {
            professionError.setValue("Please Enter Profession.");
            return;
        }

        if (!Validation.isValidEmail(email.getValue())) {
            emailError.setValue("Please Enter Valid Email. Ex:xyz@abc.com");
            return;
        }

        if (!Validation.isValidPhoneNumber(mobileNo.getValue())) {
            mobileNoError.setValue("Please Enter Valid Mobile Number. Ex:9988776655");
            return;
        }


        CreateUserRequest request = new CreateUserRequest(
                username.getValue().trim(),
                email.getValue().trim(),
                mobileNo.getValue().trim(),
                password.getValue().trim(),
                profession.getValue().trim()
        );

        isProgressEnabled.setValue(true);
        mClient.getApi().userCreate(request).enqueue(new Callback<ApiResponse<LoginData>>() {
            @Override
            public void onResponse(Call<ApiResponse<LoginData>> call, Response<ApiResponse<LoginData>> response) {
                isProgressEnabled.setValue(false);
                if(response.isSuccessful() && response.body().getData() != null) {
                    LoginData data = response.body().getData();
                    if(data.isAuthenticate()) {
                        CiestaPreference.getInstance().setAuthToken(data.getAccessToken());
                        CiestaPreference.getInstance().setUserAuthentication(data.isAuthenticate());
                        CiestaPreference.getInstance().setUserName(data.getUser().getName());
                        CiestaPreference.getInstance().setUserEmail(data.getUser().getEmail());
                        CiestaPreference.getInstance().setUserMobileNo(data.getUser().getMobile());
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
                isProgressEnabled.setValue(false);
            }
        });

    }

    public void onLoginClick() {
        launchLoginActivity.setValue(new Object());
    }

}
