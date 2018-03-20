package com.udacity.android.popularmovies;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

    public static ArrayList<Movie> parseMovie(String jsonString) {

        ArrayList<Movie> movies = new ArrayList();

        try {
            JSONArray results = new JSONArray(jsonString);


            for(int i =0; i<results.length(); i++){
                JSONObject movie = results.getJSONObject(i);

                String poster_path = movie.optString("poster_path");
                boolean adult = movie.optBoolean("adult");
                String overview = movie.optString("overview");
                String release_date= movie.optString("release_date");
                JSONArray genre_ids = movie.optJSONArray("genre_ids");
                List<String> genre_list = JSONArrayToList(genre_ids);
                int id = movie.optInt("id");
                String original_title = movie.optString("original_title");
                String original_language= movie.optString("original_language");
                String title =  movie.optString("title");
                String backdrop_path = movie.optString("backdrop_path");
                double popularity = movie.optDouble("popularity");
                int vote_count = movie.optInt("vote_count");
                boolean video = movie.optBoolean("video");
                double vote_average = movie.optDouble("vote_average");

                movies.add(new Movie(poster_path, adult, overview, release_date, genre_list,
                        id, original_title, original_language, title, backdrop_path, popularity,
                        vote_count, video, vote_average));

            }


           return movies;

        } catch (JSONException je) {
            je.printStackTrace();
            return null;
        }

    }

    private static List<String> JSONArrayToList(JSONArray array) {
        List<String> list = new ArrayList<>();
        if (null != array) {
            for (int i = 0; i < array.length(); i++) {
                try {
                    list.add(array.getString(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return list;
        }
        return null;
    }

}
