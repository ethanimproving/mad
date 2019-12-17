package org.improving.mad.api;

import org.improving.mad.MovieRepository;
import org.improving.mad.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AppAPIController {

    private MovieRepository movieRepository;

    public AppAPIController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> movies() {
        List<Movie> movies = movieRepository.getMovies();
        return movies.stream().filter(m -> !m.isDeleted()).collect(Collectors.toList());
    }

    @GetMapping("/deleted")
    public List<Movie> deletedMovies() {
        List<Movie> movies = movieRepository.getMovies();
        return movies.stream().filter(m -> m.isDeleted()).collect(Collectors.toList());
    }

    @GetMapping("/movies/{movieId}")
    public Movie movie(@PathVariable int movieId) {
        return movieRepository.getMovie(movieId);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> newMovie(@RequestBody Movie movie){
        Movie savedMovie = movieRepository.addMovie(movie.getTitle(), movie.getYear(), movie.getRating(), movie.getRunTime());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMovie.getMovieId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/movies/{movieId}/edit")
    public ResponseEntity<Movie> changeRating(@PathVariable int movieId, @RequestBody Movie movie) {
        Movie savedMovie = movieRepository.updateMovie(movieId, movie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMovie.getMovieId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable int movieId) {
        movieRepository.deleteMovie(movieId);
    }

    @PutMapping("/deleted/{movieId}/restore")
    public void restore(@PathVariable int movieId) {
        movieRepository.restoreMovie(movieId);
    }
}
