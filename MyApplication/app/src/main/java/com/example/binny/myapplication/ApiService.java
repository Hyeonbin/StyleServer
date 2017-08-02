package com.example.binny.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by binny on 2017. 8. 2..
 */

public interface ApiService {
    String API_URL = "http://10.0.2.2:3000/";

    @GET("data")
    Call<ResponseBody> getData();

}
