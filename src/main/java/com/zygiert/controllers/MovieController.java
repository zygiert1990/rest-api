package com.zygiert.controllers;

import com.zygiert.domain.Movie;
import com.zygiert.domain.Watcher;
import com.zygiert.repositories.MovieRepository;
import com.zygiert.repositories.WatcherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private final WatcherRepository watcherRepository;

    public MovieController(MovieRepository movieRepository, WatcherRepository watcherRepository) {
        this.movieRepository = movieRepository;
        this.watcherRepository = watcherRepository;
    }

    @GetMapping
    List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @GetMapping("{movieId}")
    Movie findOne(@PathVariable("movieId") long movieId) {
        return movieRepository.findOne(movieId);
    }

    @PostMapping(value = "/add")
    public Movie addMovie(
            @RequestBody Movie movieRequest) {
        Movie movie = new Movie(Movie.getNextMovieId(), movieRequest.getTitle(), movieRequest.getWatchers());
        movieRepository.save(movie);
        return movie;
    }

    @PutMapping("{movieId}/update")
    public Movie updateMovie(
            @PathVariable("movieId") long movieId,
            @RequestBody Movie requestMovie) {
        Movie movie = movieRepository.findOne(movieId);
        movie.setTitle(requestMovie.getTitle());
        if (requestMovie.getWatchers() != null)
            movie.setWatchers(requestMovie.getWatchers());
        movieRepository.save(movie);
        return movie;
    }

    @DeleteMapping("{movieId}/delete")
    public boolean deleteMovie(@PathVariable("movieId") long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        return movieRepository.delete(movie);
    }

    @GetMapping("{movieId}/watchers")
    public List<Watcher> findAllWatchers(@PathVariable("movieId") long movieId) {
        return movieRepository.findOne(movieId).getWatchers();
    }

    @GetMapping("{movieId}/watchers/{watcherId}")
    public Watcher findOneWatcher(
            @PathVariable("movieId") long movieId,
            @PathVariable("watcherId") long watcherId
    ) {
        Movie movie = movieRepository.findOne(movieId);
        watcherRepository.setWatchers(movie.getWatchers());
        return watcherRepository.findOne(watcherId);
    }

    @PostMapping("{movieId}/watchers/add")
    public Watcher addWatcher(
            @PathVariable("movieId") long movieId,
            @RequestBody Watcher requestWatcher
    ) {
        Movie movie = movieRepository.findOne(movieId);
        if (movie.getWatchers() == null) {
            watcherRepository.setWatchers(new ArrayList<Watcher>());
        } else {
            watcherRepository.setWatchers(movie.getWatchers());
        }
        Watcher watcher = new Watcher(
                Watcher.getNextWatcherId(),
                requestWatcher.getFirstName(),
                requestWatcher.getLastName(),
                requestWatcher.getComment());
        watcherRepository.save(watcher);
        movie.setWatchers(watcherRepository.findAll());
        movieRepository.save(movie);
        return watcher;
    }

    @PutMapping("{movieId}/watchers/{watcherId}/updateWatcher")
    public Watcher updateWatcher(
            @PathVariable("movieId") long movieId,
            @PathVariable("watcherId") long watcherId,
            @RequestBody Watcher requestWatcher
    ) {
        Movie movie = movieRepository.findOne(movieId);
        List<Watcher> watchers = movie.getWatchers();
        watcherRepository.setWatchers(watchers);
        Watcher watcher = watcherRepository.findOne(watcherId);
        if (requestWatcher.getComment() != null)
            watcher.setComment(requestWatcher.getComment());
        if (requestWatcher.getFirstName() != null)
            watcher.setFirstName(requestWatcher.getFirstName());
        if (requestWatcher.getLastName() != null)
            watcher.setLastName(requestWatcher.getLastName());
        return watcher;
    }

    @DeleteMapping("{movieId}/watchers/{watcherId}/delete")
    public boolean deleteWatcher(
            @PathVariable("movieId") long movieId,
            @PathVariable("watcherId") long watcherId
    ) {
        Movie movie = movieRepository.findOne(movieId);
        watcherRepository.setWatchers(movie.getWatchers());
        Watcher watcher = watcherRepository.findOne(watcherId);
        return watcherRepository.delete(watcher);
    }

}
