package org.improving.mad;

import org.improving.mad.database.JPAUtility;
import org.improving.mad.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MovieRepository {

    public List<Movie> getMovies() {
        EntityManager em = JPAUtility.getEntityManager();
        String query = "select m from Movie as m";
        TypedQuery<Movie> tq = em.createQuery(query, Movie.class);
        List<Movie> movies;
        try {
            movies = tq.getResultList();
            return movies;
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
