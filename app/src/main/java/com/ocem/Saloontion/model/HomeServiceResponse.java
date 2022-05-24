package com.ocem.Saloontion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeServiceResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("servicename")
    @Expose
    private String servicename;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("images")
    @Expose
    private String images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HomeServiceResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public HomeServiceResponse withServicename(String servicename) {
        this.servicename = servicename;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public HomeServiceResponse withDetails(String details) {
        this.details = details;
        return this;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public HomeServiceResponse withImages(String images) {
        this.images = images;
        return this;
    }

}
