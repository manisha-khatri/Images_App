package com.example.imagesapp.view.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.imagesapp.R;
import com.example.imagesapp.constants.ImageConstants;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ImageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_details);
        setToolbar();
        setImageMetadata();
    }

    void setToolbar(){
        setSupportActionBar((Toolbar) findViewById(R.id.appToolbar));
        TextView tv = findViewById(R.id.toolbarTextView);
        tv.setText("Image Details Screen");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setImageMetadata() {
        String content = (getIntent().hasExtra(ImageConstants.CONTENT)) ? getIntent().getStringExtra(ImageConstants.CONTENT) : "";
        String image = (getIntent().hasExtra(ImageConstants.IMAGE)) ? getIntent().getStringExtra(ImageConstants.IMAGE) : "";//TITLE
        String title = (getIntent().hasExtra(ImageConstants.TITLE)) ? getIntent().getStringExtra(ImageConstants.TITLE) : "";

        TextView imageDescription = findViewById(R.id.imageDescription);
        TextView imageTitle = findViewById(R.id.imageTitle);

        imageDescription.setText(content);
        imageTitle.setText(title);


        ImageView imageView = findViewById(R.id.detailPageIV);
        if (image != null && image != "" && image != " ") {
            Picasso.with(getApplicationContext())
                    .load(image)
                    .into(imageView);
        }
        else
            imageView.setImageResource(R.drawable.image_not_present);

    }
}
