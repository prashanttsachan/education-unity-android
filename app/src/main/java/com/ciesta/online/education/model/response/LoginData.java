package com.ciesta.online.education.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("authenticate")
    private boolean authenticate;

    @SerializedName("user")
    private User user;

    public LoginData(String accessToken, boolean authenticate, User user) {
        this.accessToken = accessToken;
        this.authenticate = authenticate;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        this.authenticate = authenticate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
