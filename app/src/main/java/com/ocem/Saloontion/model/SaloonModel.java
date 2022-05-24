package com.ocem.Saloontion.model;

public class SaloonModel {

    private String Title;
    private int Thumbnail;
    private String Address;
    private String Phone;

    public SaloonModel() {
    }

    public SaloonModel(String title, int thumbnail, String address, String phone) {
        Title = title;
        Thumbnail = thumbnail;
        this.Address = address;
        this.Phone = phone;
    }

    public String getTitle() { return Title; }

    public void setTitle(String title) {
        Title = title;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }
}




