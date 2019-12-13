package org.improving.mad;

import org.improving.mad.database.JPAUtility;
import org.improving.mad.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MovieRepository {

    // CREATE

    public void addMovie(String title, int year, int rating, int runTime) {
        EntityManager em = JPAUtility.getEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setYear(year);
            movie.setRating(rating);
            movie.setRunTime(runTime);
            em.persist(movie);
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    // READ

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

    public Movie getMovie(int id) {
        EntityManager em = JPAUtility.getEntityManager();
        String query = "select c from Movie c where c.id = :movieId";

        TypedQuery<Movie> tq = em.createQuery(query, Movie.class);
        tq.setParameter("movieId", id);
        Movie movie;
        try {
            movie = tq.getSingleResult();
            return movie;
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // UPDATE

    public void changeRating(int id, int rating) {
        EntityManager em = JPAUtility.getEntityManager();
        EntityTransaction et = null;
        Movie movie = null;
        try {
            et = em.getTransaction();
            et.begin();
            movie = em.find(Movie.class, id);
            movie.setRating(rating);

            em.persist(movie);
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

}
