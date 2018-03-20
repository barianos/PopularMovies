package com.udacity.android.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ArrayList<Movie> movies;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = null; //TODO Check if NEEDED



        imageView = findViewById(R.id.imageView);

        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this)
                .load("https://i.imgur.com/DvpvklR.png")
                .resize(300,300)
                .into(imageView);
//        Picasso.with(this)
//                .load("http://i.imgur.com/DvpvklR.png")
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(imageView);



        new FetchMovies(this, this).execute();


    }


}
