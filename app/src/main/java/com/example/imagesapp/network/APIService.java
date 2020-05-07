package com.example.imagesapp.network;

import com.example.imagesapp.model.ImagesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("customsearch/v1")
    Call<ImagesResponse> customSearch(
            @Query("q") String searchedString,
            @Query("cx") String cx,
            @Query("key") String key
    );
}
