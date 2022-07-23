package com.me.domain;

public class AutoImg {
    private int id;
    private String image;

    public AutoImg() { }

    public AutoImg(int id, String image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "AutoImg{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
