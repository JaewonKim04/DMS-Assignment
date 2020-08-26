package com.rest;

import com.google.gson.Gson;

import java.net.URI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {
    public static final String DATE_URL="https://api.github.com/";
    public static Retrofit retrofit=null;

    public static Retrofit getClient()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(DATE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
