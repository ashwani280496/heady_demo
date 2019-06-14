package com.example.headydemo.Models;

import com.example.headydemo.Models.MultimediaModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookModel {
    private String title;

    @SerializedName("abstract")
    private String abstractText;

    @SerializedName("auther")
    private String byline;

    private  String url;

    private List<MultimediaModel> multimedia;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MultimediaModel> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<MultimediaModel> multimedia) {
        this.multimedia = multimedia;
    }
}
