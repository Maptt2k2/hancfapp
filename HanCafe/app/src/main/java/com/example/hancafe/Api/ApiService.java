package com.example.hancafe.Api;

import com.example.hancafe.Model.CategoryProduct;
import com.example.hancafe.Model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // Link API mẫu: https://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    // http://localhost:8888/api/category/list
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8888/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("api/category/")
    Call<ApiResponse<List<CategoryProduct>>> getCategoryList();

    @GET("api/product/")
    Call<ApiResponse<List<Product>>> getProductList();
}
