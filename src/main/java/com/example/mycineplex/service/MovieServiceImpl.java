package com.example.mycineplex.service;

import com.example.mycineplex.entity.Movie;
import com.example.mycineplex.repo.MovieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class MovieServiceImpl implements MovieService {
    MovieRepo movieRepo;

    @Override
    public Optional<Movie> createMovie(Movie movie) {
        return Optional.of(movieRepo.save(movie));
    }

    @Override
    public List<Movie> createAll(List<Movie> movies) {
        return movieRepo.saveAll(movies);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Integer id) {
        return movieRepo.findById(id);
    }


}
