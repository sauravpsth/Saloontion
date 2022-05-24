package com.ocem.Saloontion.model;

public class RecommendedModel {

    private int Thumbnail;
    private String Title;
    private String Address;
    private String Phone;



    public RecommendedModel(int thumbnail, String title, String address, String phone) {
        this.Thumbnail =thumbnail;
        this.Title = title;
        this.Address = address;
        this.Phone = phone;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) { Title = title; }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}

