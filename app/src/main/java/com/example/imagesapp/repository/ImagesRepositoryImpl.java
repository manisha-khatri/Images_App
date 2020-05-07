package com.example.imagesapp.repository;

import android.util.Log;
import com.example.imagesapp.callback.APIResponseCallBack;
import com.example.imagesapp.constants.NetworkConstants;
import com.example.imagesapp.model.ImagesResponse;
import com.example.imagesapp.network.APIService;
import com.example.imagesapp.network.Retrofit2Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagesRepositoryImpl implements ImagesRepository{
    APIService apiService;
    Call<ImagesResponse> call;

    public ImagesRepositoryImpl(){
        apiService = Retrofit2Client.getRetrofitInstance().create(APIService.class);
    }

    public void fetchImageRecords(APIResponseCallBack apiResponseCallBack, String key){
        call = apiService.customSearch(
                key,
                NetworkConstants.CX,
                NetworkConstants.API_KEY
        );
        fetchNewsFromServer(call, apiResponseCallBack);
    }

    private void fetchNewsFromServer(Call<ImagesResponse> call, final APIResponseCallBack apiResponseCallBack ) {
        call.enqueue(new Callback<ImagesResponse>() {
            @Override
            public void onResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                Log.e("Response", response.toString());
                apiResponseCallBack.onSuccessfulResponse(call, response);
            }
            @Override
            public void onFailure(Call<ImagesResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
                apiResponseCallBack.onFailureResponse(call,t);
            }
        });
    }



}
