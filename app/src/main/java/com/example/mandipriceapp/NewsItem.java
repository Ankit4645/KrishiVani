package com.example.mandipriceapp;

public class NewsItem {
    private int imageResId;
    private String headline;

    public NewsItem(int imageResId, String headline) {
        this.imageResId = imageResId;
        this.headline = headline;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getHeadline() {
        return headline;
    }
}
