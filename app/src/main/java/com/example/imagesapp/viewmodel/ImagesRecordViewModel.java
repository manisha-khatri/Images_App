package com.example.imagesapp.viewmodel;

import com.example.imagesapp.callback.APIResponseCallBack;
import com.example.imagesapp.model.ImagesResponse;
import com.example.imagesapp.repository.ImagesRepository;
import com.example.imagesapp.repository.ImagesRepositoryImpl;
import com.example.imagesapp.view.state.ErrorState;
import com.example.imagesapp.view.state.ProgressState;
import com.example.imagesapp.view.state.SuccessState;
import com.example.imagesapp.view.state.ViewState;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Response;

public class ImagesRecordViewModel extends ViewModel {
    private ImagesRepository imagesRepository;
    private MutableLiveData<ViewState> viewStateMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<ViewState> getViewState() {
        return viewStateMutableLiveData;
    }

    public ImagesRecordViewModel() {
        super();
        //TODO: this instance should be injected by a dagger
        imagesRepository = new ImagesRepositoryImpl();
    }

    public void loadImages(String searchedString) {
        viewStateMutableLiveData.setValue(new ProgressState());
        String str = searchedString.replaceAll("\\s", "");
        str = str.toLowerCase();

        imagesRepository.fetchImageRecords(new APIResponseCallBack() {
            @Override
            public void onSuccessfulResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
                handleResponse(call, response);
            }

            @Override
            public void onFailureResponse(Call<ImagesResponse> call, Throwable t) {
                viewStateMutableLiveData.setValue(new ErrorState("Cannot fetch response from server"));
            }
        }, str);
    }

    private void handleResponse(Call<ImagesResponse> call, Response<ImagesResponse> response) {
        if (response.isSuccessful()) {
            ImagesResponse images = response.body();
            assert images != null;
            if (images.getItems().length > 0) {
                viewStateMutableLiveData.setValue(new SuccessState(images.getItems()));
            } else {
                viewStateMutableLiveData.setValue(new ErrorState("No Image found"));
            }
        } else {
            viewStateMutableLiveData.setValue(new ErrorState("Cannot fetch response from server"));
        }
    }


}