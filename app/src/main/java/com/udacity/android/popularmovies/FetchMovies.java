package com.udacity.android.popularmovies;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class FetchMovies extends AsyncTask<Object, Void, Object> {


    private Context context;
    private MainActivity main;

    public FetchMovies(Context context, MainActivity main) {
        this.context = context;
        this.main = main;

    }

    ArrayList<Movie> movies;

    @Override
    protected Object doInBackground(Object[] objects) {
//    protected Object doInBackground(Object[] objects) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + context.getString(R.string.movie_db_api_key) + "&language=en-US&page=1";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        movies = JSONUtils.parseMovie(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
            }
        });

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        main.movies = this.movies;


    }
}
