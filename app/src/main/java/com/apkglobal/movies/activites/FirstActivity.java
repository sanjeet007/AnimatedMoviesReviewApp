package com.apkglobal.movies.activites;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.apkglobal.movies.R;
import com.apkglobal.movies.model.Anime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getSupportActionBar().hide();

        String name=getIntent().getExtras().getString("anime_name");
        String description=getIntent().getExtras().getString("anime_description");
        String studio=getIntent().getExtras().getString("anime_studio");
        String category=getIntent().getExtras().getString("anime_category");
        String episode=getIntent().getExtras().getString("anime_episode");
        String img_url=getIntent().getExtras().getString("anime_img");
        String rating=getIntent().getExtras().getString("anime_rating");


        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsingToolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name=findViewById(R.id.aa_anime_name_id);
        TextView tv_description=findViewById(R.id.aa_description);
        TextView tv_studio=findViewById(R.id.aa_studio_id);
        TextView tv_category=findViewById(R.id.aa_categories_id);
        TextView tv_rating=findViewById(R.id.aa_rating_id);
        ImageView img=findViewById(R.id.aa_thumbnail);

        collapsingToolbarLayout.setTitle(name);

        tv_name.setText(name);
        tv_description.setText(description);
        tv_studio.setText(studio);
        tv_category.setText(category);
        tv_rating.setText(rating);

        RequestOptions option=new RequestOptions().centerCrop().
                placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        //set image using Glide
        Glide.with(this).load(img_url).apply(option).into(img);


    }

}