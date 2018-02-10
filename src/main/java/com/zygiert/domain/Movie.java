package com.zygiert.domain;

import java.util.List;

public class Movie {
    private long movieId;
    private String title;
    private List<Watcher> watchers;
    private static long lastMovieId = 1;

    public Movie(){}

    public Movie(long id, String title, List<Watcher> watchers) {
        this.movieId = id;
        this.title = title;
        this.watchers = watchers;
    }

    public static long getNextMovieId() {
        return lastMovieId++;
    }

    public long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public List<Watcher> getWatchers() {
        return watchers;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWatchers(List<Watcher> watchers) {
        this.watchers = watchers;
    }

    public static void setLastMovieId(long lastMovieId) {
        Movie.lastMovieId = lastMovieId;
    }
}
