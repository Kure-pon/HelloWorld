package com.grntea.ygocard.Models;

public class cardImage {
    private int id;
    private String image_url;
    private String image_url_small;

    public cardImage(int id, String image_url, String image_url_small) {
        this.id = id;
        this.image_url = image_url;
        this.image_url_small = image_url_small;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url_small() {
        return image_url_small;
    }

    public void setImage_url_small(String image_url_small) {
        this.image_url_small = image_url_small;
    }
}
