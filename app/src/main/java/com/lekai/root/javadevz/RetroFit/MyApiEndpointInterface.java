package com.lekai.root.javadevz.RetroFit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by root on 3/8/17.
 */

public interface MyApiEndpointInterface {


        // Request method and URL specified in the annotation

        // Callback for the parsed response is the last parameter


        @GET("users?q=+location:lagos+language:java?access_token:85489f7fdeb964a14917893c8b1d08235227f13f")
        Call<List<Item>> getUsers();








//        @POST("users/new")
//
//        Call<> createUser(@Body User user);

    }

