package org.improving.mad;

import org.improving.mad.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {

    public List<Movie> getMovies() {
        return Arrays.asList(
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107),
                new Movie("Ethan Strikes Back", 2019, 10, "Ethan Miller", 107)
        );
    }

}
