package com.example.jd.praticalround.Retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JD on 01-07-2017.
 */

public class ApiClient {
    public static final String BASE_URL="http://202.131.125.125:8080/";
    public  static Retrofit retrofit= null;


    public static Retrofit getRetrofit()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
