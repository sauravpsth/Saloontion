package com.ocem.Saloontion.network;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAll {

    private static retrofit2.Retrofit retrofit;

    public static retrofit2.Retrofit getRetrofitClient(String base_URL) {
        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}


