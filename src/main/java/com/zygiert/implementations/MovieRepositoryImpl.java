package com.zygiert.implementations;

import com.zygiert.domain.Movie;
import com.zygiert.domain.Watcher;
import com.zygiert.repositories.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private Map<Long, Movie> movies;

    public MovieRepositoryImpl() {
        Movie movie = new Movie(
                Movie.getNextMovieId(),
                "Gwiezdne Wojny",
                new ArrayList<Watcher>(
                        Arrays.asList(
                                new Watcher(
                                        Watcher.getNextWatcherId(),
                                        "Jan",
                                        "Kowalski"))));
        movies = new HashMap<Long, Movie>();
        movies.put(movie.getMovieId(), movie);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies.values());
    }

    @Override
    public Movie findOne(long movieId) {
        return movies.get(movieId);
    }

    @Override
    public Movie save(Movie movie) {
        return movies.put(movie.getMovieId(), movie);
    }

    @Override
    public boolean delete(Movie movie) {
        return movies.remove(movie.getMovieId(), movie);
    }

}
