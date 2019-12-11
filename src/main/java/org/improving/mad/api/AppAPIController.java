package org.improving.mad.api;

import org.improving.mad.MovieRepository;
import org.improving.mad.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppAPIController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> movies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{movieId}")
    public Movie movies(@PathVariable int movieId) {
        return movieRepository.findById(movieId);
    }

}
