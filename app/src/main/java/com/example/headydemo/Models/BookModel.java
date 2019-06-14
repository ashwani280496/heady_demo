package com.example.headydemo.Models;

import com.example.headydemo.Models.MultimediaModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookModel {
    private String title;

    @SerializedName("abstract")
    private String abstractText;

    private String byline;

    private String published_date;

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

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }
}
