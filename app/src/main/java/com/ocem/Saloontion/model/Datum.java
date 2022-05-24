package com.ocem.Saloontion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private Integer phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("saloon_id")
    @Expose
    private Integer saloonId;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("service_id")
    @Expose
    private Integer serviceId;
    @SerializedName("saloonname")
    @Expose
    private String saloonname;
    @SerializedName("servicename")
    @Expose
    private String servicename;
    @SerializedName("images")
    @Expose
    private String images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Datum withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Datum withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Datum withTime(String time) {
        this.time = time;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Datum withDate(String date) {
        this.date = date;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Datum withPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Datum withEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getSaloonId() {
        return saloonId;
    }

    public void setSaloonId(Integer saloonId) {
        this.saloonId = saloonId;
    }

    public Datum withSaloonId(Integer saloonId) {
        this.saloonId = saloonId;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Datum withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Datum withServiceId(Integer serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public String getSaloonname() {
        return saloonname;
    }

    public void setSaloonname(String saloonname) {
        this.saloonname = saloonname;
    }

    public Datum withSaloonname(String saloonname) {
        this.saloonname = saloonname;
        return this;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public Datum withServicename(String servicename) {
        this.servicename = servicename;
        return this;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Datum withImages(String images) {
        this.images = images;
        return this;
    }
}