package com.example.testapp.service;

import com.example.testapp.model.BoxOfficeResult;
import com.example.testapp.model.MyPojo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("searchDailyBoxOfficeList.json")
    Call<MyPojo> findAll(@Query("key") String key, @Query("targetDt") String targetDt); // get방식

//    @POST("posts/post")
//    Call<Result> postInfo(@Header("token") String token, @Body String body); // post방식
}
