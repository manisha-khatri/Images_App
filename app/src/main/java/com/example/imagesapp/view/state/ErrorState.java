package com.example.imagesapp.view.state;

public class ErrorState implements ViewState {
    public String errorMsg;

    public ErrorState(String errorMsg){
        this.errorMsg = errorMsg;
    }

}
