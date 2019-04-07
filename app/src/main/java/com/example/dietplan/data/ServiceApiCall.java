package com.example.dietplan.data;

import com.example.dietplan.data.Model.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApiCall {

    @GET(".")
    Call<Response> getUserList();
}
