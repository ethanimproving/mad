package org.improving.mad.api;

import org.improving.mad.MovieRepository;
import org.improving.mad.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppAPIController {

    private MovieRepository movieRepository;

    public AppAPIController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> movies() {
        return movieRepository.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie movie(@PathVariable int movieId) {
        return movieRepository.getMovie(movieId);
    }

    // TODO: Take params as header keys instead of query params
    @PostMapping("/movies/form")
    public void createMovie(@RequestParam String title, @RequestParam int year, @RequestParam int rating,
                       @RequestParam int runTime) {
        movieRepository.addMovie(title, year, rating, runTime);
    }

    @PutMapping("/movies/{movieId}")
    public void changeRating(@PathVariable int movieId, @RequestParam int rating) {
        movieRepository.changeRating(movieId, rating);
    }
}
