package com.ocem.Saloontion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServicesResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("saloon_id")
    @Expose
    private Integer saloonId;
    @SerializedName("service_id")
    @Expose
    private Integer serviceId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("service_name")
    @Expose
    private String serviceName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("image")
    @Expose
    private String image;
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

    public ServicesResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSaloonId() {
        return saloonId;
    }

    public void setSaloonId(Integer saloonId) {
        this.saloonId = saloonId;
    }

    public ServicesResponse withSaloonId(Integer saloonId) {
        this.saloonId = saloonId;
        return this;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public ServicesResponse withServiceId(Integer serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ServicesResponse withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ServicesResponse withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServicesResponse withName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ServicesResponse withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ServicesResponse withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ServicesResponse withDetails(String details) {
        this.details = details;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ServicesResponse withImage(String image) {
        this.image = image;
        return this;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public ServicesResponse withServicename(String servicename) {
        this.servicename = servicename;
        return this;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public ServicesResponse withImages(String images) {
        this.images = images;
        return this;
    }

}
