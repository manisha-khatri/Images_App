package com.example.imagesapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.imagesapp.R;
import com.example.imagesapp.constants.ImageConstants;
import com.example.imagesapp.model.Items;
import com.example.imagesapp.view.adapter.ImagesRecrdRecyclerviewAdapter;
import com.example.imagesapp.view.state.ErrorState;
import com.example.imagesapp.view.state.ProgressState;
import com.example.imagesapp.view.state.SuccessState;
import com.example.imagesapp.view.state.ViewState;
import com.example.imagesapp.viewmodel.ImagesRecordViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ImagesRecordActivity extends AppCompatActivity implements ImagesRecrdRecyclerviewAdapter.RecyclerViewListener{

    ImagesRecordViewModel imagesRecordViewModel;
    LinearLayout progressBar;
    TextView errorMsgTV;
    LinearLayout errorMsgLayout;
    RecyclerView imagesRecrdRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_record);
        initViews();
        initObserver();
        initData(getSearchedKeywordFromIntent());
    }

    private void initViews() {
        setToolbar();
         progressBar = findViewById(R.id.progressBar);
         errorMsgTV = findViewById(R.id.errorMsg);
         errorMsgLayout = findViewById(R.id.errorMsgLayout);
         imagesRecrdRecyclerView = findViewById(R.id.recyclerview);
    }

    public void setImagesInAdapter(Items[] imagesRecord) {
        RecyclerView imagesRecrdRecyclerView = findViewById(R.id.recyclerview);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        imagesRecrdRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        ImagesRecrdRecyclerviewAdapter customAdapter = new ImagesRecrdRecyclerviewAdapter(imagesRecord,this, this);
        imagesRecrdRecyclerView.setAdapter(customAdapter);
    }

    private void initData(String searchedString) {
        imagesRecordViewModel.loadImages(searchedString);
    }

    private void initObserver() {
        imagesRecordViewModel = ViewModelProviders.of(this).get(ImagesRecordViewModel.class);
        imagesRecordViewModel.getViewState().observe(this, new Observer<ViewState>() {
            @Override
            public void onChanged(ViewState viewState) {
                if(viewState instanceof ErrorState){
                    progressBar.setVisibility(View.GONE);
                    errorMsgLayout.setVisibility(View.VISIBLE);
                    imagesRecrdRecyclerView.setVisibility(View.GONE);

                    String errorMsg = ((ErrorState) viewState).errorMsg;
                    errorMsgTV.setText(errorMsg);
                }
                else if(viewState instanceof ProgressState){
                    progressBar.setVisibility(View.VISIBLE);
                    errorMsgLayout.setVisibility(View.GONE);
                    imagesRecrdRecyclerView.setVisibility(View.GONE);
                }
                else if(viewState instanceof SuccessState){
                    progressBar.setVisibility(View.GONE);
                    errorMsgLayout.setVisibility(View.GONE);
                    imagesRecrdRecyclerView.setVisibility(View.VISIBLE);

                    Items[] imagesRecord = ((SuccessState) viewState).items;
                    setImagesInAdapter(imagesRecord);
                }
            }
        });
    }

    private String getSearchedKeywordFromIntent() {
        return (getIntent().hasExtra(ImageConstants.SEARCHED_KEYWORD)) ? getIntent().getStringExtra(ImageConstants.SEARCHED_KEYWORD) : "";
    }

    void setToolbar(){
        setSupportActionBar((Toolbar) findViewById(R.id.appToolbar));
        setSupportActionBar((Toolbar) findViewById(R.id.appToolbar));
        TextView tv = findViewById(R.id.toolbarTextView);
        tv.setText(R.string.images_record_screen);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onItemClick(Items items) {
        Intent intent = new Intent(ImagesRecordActivity.this, ImageDetailsActivity.class);
        intent.putExtra(ImageConstants.CONTENT, items.getSnippet());

        if(items.getPagemap()!=null &&  items.getPagemap().getCse_image()!=null && items.getPagemap().getCse_image().length>0 && items.getPagemap().getCse_image()[0].getSrc()!=null) {
            intent.putExtra(ImageConstants.IMAGE, items.getPagemap().getCse_image()[0].getSrc());
        }
        intent.putExtra(ImageConstants.TITLE, items.getTitle());
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
