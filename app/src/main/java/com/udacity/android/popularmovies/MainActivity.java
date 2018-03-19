package com.udacity.android.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;



public class MainActivity extends AppCompatActivity {

    ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new FetchMovies(this).execute();

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


    }


}
