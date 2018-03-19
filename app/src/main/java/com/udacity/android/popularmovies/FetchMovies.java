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

public class FetchMovies extends AsyncTask {


    private Context context;

    public FetchMovies(Context context){
        this.context = context;
    }


    @Override
    protected Object doInBackground(Object[] objects) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+ context.getString(R.string.movie_db_api_key)+"&language=en-US&page=1";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("responce" , response);
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
                Log.d("error", error.toString());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        return null;
    }
}
