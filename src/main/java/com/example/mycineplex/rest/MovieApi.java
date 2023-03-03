package com.example.mycineplex.rest;

import com.example.mycineplex.entity.Movie;
import com.example.mycineplex.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class MovieApi {
    private final MovieService movieService;

    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public Optional<Movie> createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);

    }
    @PostMapping("/movies")
   public List<Movie> createAll (@RequestBody List<Movie> movies){
        return movieService.createAll(movies);
    }

    @GetMapping("/movies")
   public List<Movie> getAllMovies () {
      return movieService.getAllMovies();
    }
    @GetMapping("/{id}/movie")
    Optional<Movie> getMovieById(@PathVariable (name = "id") @RequestBody int id){
    return movieService.getMovieById(id);

    }
}
