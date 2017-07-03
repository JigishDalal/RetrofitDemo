package com.example.jd.praticalround.Retrofit;

import com.example.jd.praticalround.Model.Contact;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by JD on 01-07-2017.
 */

public interface ApiInterface {

    @Headers({"ContentType:application/json",
            "Accept:application/json"})
    @GET("/gratzeez-api-stripe/user/getUsers")
    Call<List<Contact>> getContact();

}
