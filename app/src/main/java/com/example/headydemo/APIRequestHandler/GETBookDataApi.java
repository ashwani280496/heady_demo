package com.example.headydemo.APIRequestHandler;

import com.example.headydemo.Models.ResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GETBookDataApi {

    String BASE_URL = "https://api.nytimes.com/svc/topstories/v2/";

    @GET("books.json?api-key=kRxJgT0VU6BKdfHYEysnPAaj6e0bFvCy")
    Call<ResponseModel> getAllResults();
}