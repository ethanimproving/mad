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
    public Movie movies(@PathVariable int movieId) {
        return movieRepository.getMovie(movieId);
    }
}
