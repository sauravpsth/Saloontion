package com.ocem.Saloontion.network;

public class ApiUtils {
    private static String Base_URL = "http://saloon.oxfordcollege.edu.np/api/";

    public static Services getServices() {
        return RetrofitAll.getRetrofitClient(Base_URL).create(Services.class);
    }
}



