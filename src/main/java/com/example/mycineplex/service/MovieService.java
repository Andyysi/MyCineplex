package com.example.mycineplex.service;

import com.example.mycineplex.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<Movie> createMovie (Movie movie);

    List<Movie> createAll(List<Movie> movies);

    List<Movie> getAllMovies ();
    public Optional<Movie> getMovieById (Integer id);
}
