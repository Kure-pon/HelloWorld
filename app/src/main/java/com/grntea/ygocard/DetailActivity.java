package com.grntea.ygocard;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.grntea.ygocard.Models.card;

public class DetailActivity extends AppCompatActivity {
    TextView title, type,desc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        view();
        card card = getIntent().getParcelableExtra("card");
        String url = getIntent().getStringExtra("image");
        title.setText(card.getName());
        type.setText(card.getType());
        desc.setText(card.getDesc());
        Glide.with(getApplicationContext())
                .load(url)
                .placeholder(R.drawable.card_back).into(img);

    }

    public void view(){
        title = findViewById(R.id.Title_detail);
        type = findViewById(R.id.type_detail);
        desc = findViewById(R.id.desc_detail);
        img = findViewById(R.id.image_detail);
    }
}