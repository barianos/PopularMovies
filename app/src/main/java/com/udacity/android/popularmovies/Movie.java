package com.udacity.android.popularmovies;


import java.util.List;

public class Movie {
    String poster_path;
    boolean adult;
    String overview;
    String release_date;
    List<String> genre_ids;
    int id;
    String original_title;
    String original_language;
    String title;
    String backdrop_path;
    double popularity;
    int vote_count;
    boolean video;
    double vote_average;


    public Movie(String poster_path,
                 boolean adult,
                 String overview,
                 String release_date,
                 List<String> genre_ids,
                 int id,
                 String original_title,
                 String original_language,
                 String title,
                 String backdrop_path,
                 double popularity,
                 int vote_count,
                 boolean video,
                 double vote_average) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview =overview;
        this.release_date = release_date;
        this.genre_ids = genre_ids;
        this.id = id;
        this.original_title =  original_title;
        this.original_language = original_language;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video =  video;
        this.vote_average = vote_average;
    }

}
