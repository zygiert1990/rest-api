package com.zygiert.repositories;

import com.zygiert.domain.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();

    Movie findOne(long movieId);

    Movie save(Movie movie);

    boolean delete(Movie movie);

}
