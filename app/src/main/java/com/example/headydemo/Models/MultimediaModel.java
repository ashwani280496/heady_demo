package com.example.headydemo.Models;

import com.google.gson.annotations.SerializedName;

public class MultimediaModel {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
