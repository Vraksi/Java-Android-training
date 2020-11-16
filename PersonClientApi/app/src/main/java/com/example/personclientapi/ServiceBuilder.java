package com.example.personclientapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder
{
    private static final String URL = "http://192.168.43.17:9002/JavaAPI/api/";
    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory((GsonConverterFactory.create())).build();

    public static <S> S buildService(Class<S> serviceType)
    {
        return retrofit.create(serviceType);
    }


}
