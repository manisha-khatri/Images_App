package com.example.imagesapp.view.state;

import com.example.imagesapp.model.Items;

public class SuccessState implements ViewState{
   public  Items[] items;

    public SuccessState(Items[] items){
        this.items = items;
    }
}
