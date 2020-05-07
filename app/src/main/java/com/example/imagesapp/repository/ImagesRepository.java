package com.example.imagesapp.repository;

import com.example.imagesapp.callback.APIResponseCallBack;

public interface ImagesRepository {
    void fetchImageRecords(APIResponseCallBack apiResponseCallBack, String key);

}
//interface