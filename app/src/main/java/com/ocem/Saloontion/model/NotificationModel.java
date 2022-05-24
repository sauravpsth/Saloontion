package com.ocem.Saloontion.model;

public class NotificationModel {

    private String Title;
    private String Time;
    private String Detail;

    public NotificationModel(String title, String time, String detail) {
        Title = title;
        Time = time;
        Detail = detail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
