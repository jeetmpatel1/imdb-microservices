package com.imdb.models;

public class Movie {
    private  String movieId;
    private  String name;

    /*
    While Unmarshalling of Movie Object over net, converting Text to Movie Object, RestTemplate first create empty object.
    To create that empty object, Java needs this empty constructor.
     */
    public Movie() {
    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
