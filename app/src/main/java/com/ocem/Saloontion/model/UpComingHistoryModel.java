package com.ocem.Saloontion.model;

public class UpComingHistoryModel {
    private String Title;
    private int Thumbnail;
    private String Phone;
    private String Price;
    private String Date;
    private String Time;

    public UpComingHistoryModel() {
    }

    public UpComingHistoryModel(String title, int thumbnail, String phone, String price, String date, String time) {
        Title = title;
        Thumbnail = thumbnail;
        Phone = phone;
        Price = price;
        Date = date;
        Time = time;
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


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}

