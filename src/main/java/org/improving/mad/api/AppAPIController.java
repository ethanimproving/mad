package org.improving.mad.api;

import org.improving.mad.MovieRepository;
import org.improving.mad.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/movies")
    public void newMovie(@RequestBody Movie movie){
        movieRepository.addMovie(movie.getTitle(), movie.getYear(), movie.getRating(), movie.getRunTime());
    }

    @PutMapping("/movies/{movieId}")
    public void changeRating(@PathVariable int movieId, @RequestParam int rating) {
        movieRepository.changeRating(movieId, rating);
    }
}
