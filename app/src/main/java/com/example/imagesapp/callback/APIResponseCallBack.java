package com.example.imagesapp.callback;

import com.example.imagesapp.model.ImagesResponse;
import retrofit2.Call;
import retrofit2.Response;

public interface APIResponseCallBack {
    void onSuccessfulResponse(Call<ImagesResponse> call, Response<ImagesResponse> response);
    void onFailureResponse(Call<ImagesResponse> call, Throwable t);
}
