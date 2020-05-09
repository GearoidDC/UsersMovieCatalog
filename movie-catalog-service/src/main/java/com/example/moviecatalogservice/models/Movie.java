package com.example.moviecatalogservice.models;

public class Movie {
    private String movieId;
    private String title;
    private String summary;

    public Movie() {

    }


    public Movie(String movieId, String title, String summary) {
        this.movieId = movieId;
        this.title = title;
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }
}
