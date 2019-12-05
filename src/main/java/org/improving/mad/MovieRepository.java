package org.improving.mad;

import org.improving.mad.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {

    public List<Movie> getMovies() {
        return Arrays.asList(
                new Movie("Impactful", 1953, 2, "Barrett Crooks", 112),
                new Movie("Intelligent Lock", 1941, 7, "Laurence Greenfelder", 181),
                new Movie("Incentivize Ukraine Pizza", 1936, 6, "Renee O'Conner", 157),
                new Movie("Garden Tasty Drives", 1901, 3, "Eric Lockman", 115),
                new Movie("Application", 1901, 2, "Bryce Leffler", 141),
                new Movie("Experiences District Generic", 1982, 4, "Jessica Haag", 163),
                new Movie("Synergized", 1986, 9, "Arlo Rosenbaum", 159),
                new Movie("Connecting", 1912, 5, "Merritt Brown", 186),
                new Movie("Capacitor ADP", 1955, 7, "Jazlyn Welch", 159),
                new Movie("Soap Approach index", 1975, 9, "Tevin Wintheiser", 179),
                new Movie("Dedicated", 1975, 2, "Bartholome Turner", 152)
        );
    }

}
