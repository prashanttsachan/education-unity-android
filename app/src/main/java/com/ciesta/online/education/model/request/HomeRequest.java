package com.ciesta.online.education.model.request;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeRequest {

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("subTitle")
    @Expose
    private String subTitle;

    public HomeRequest(String image, String title, String subTitle) {
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
