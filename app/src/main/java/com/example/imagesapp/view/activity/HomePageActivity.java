package com.example.imagesapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.imagesapp.R;
import com.example.imagesapp.constants.ImageConstants;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        setToolbar();
        onSearchBtnClickListener();
    }

    void setToolbar(){
        setSupportActionBar((Toolbar) findViewById(R.id.appToolbar));
        TextView tv = findViewById(R.id.toolbarTextView);
        tv.setText(R.string.search_screen);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void onSearchBtnClickListener() {
        findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText searchedKeyword = findViewById(R.id.searchedKeyword);
                String keyword = searchedKeyword.getText().toString();

                if(isSearchekeywordValid(keyword)){
                    startImageRecordActivity(keyword);
                }
            }
        });
    }

    private void startImageRecordActivity(String keyword) {
        Intent intent = new Intent(HomePageActivity.this, ImagesRecordActivity.class);
        intent.putExtra(ImageConstants.SEARCHED_KEYWORD, keyword);
        startActivity(intent);
    }

    boolean isSearchekeywordValid(String searchedKeyword){
        if(searchedKeyword == null || searchedKeyword.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.please_enter_some_text_to_search, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
