package com.ciesta.online.education.network;

import com.ciesta.online.education.model.request.CreateUserRequest;
import com.ciesta.online.education.model.request.HomeRequest;
import com.ciesta.online.education.model.request.LoginRequest;
import com.ciesta.online.education.model.response.ApiResponse;
import com.ciesta.online.education.model.response.LoginData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/user/login")
    Call<ApiResponse<LoginData>> userLogin(@Body LoginRequest request);


    @POST("/user/create")
    Call<ApiResponse<LoginData>> userCreate(@Body CreateUserRequest request);

    @POST("/social-work/create")
    Call<ApiResponse<LoginData>> userHome(@Body HomeRequest request);

}
