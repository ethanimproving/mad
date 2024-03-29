package org.improving.mad;

import org.improving.mad.database.JPAUtility;
import org.improving.mad.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    // CREATE

    public Movie addMovie(String title, int year, int rating, int runTime) {
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
            return movie;
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
        return null;
    }

    // READ

    private List<Movie> getAllMovies() {
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

    public List<Movie> getMovies() {
        List<Movie> movies = getAllMovies();
        var nonDeletedMovies = movies.stream().filter(m -> !m.isDeleted()).collect(Collectors.toList());
        return nonDeletedMovies.stream().filter(m -> m.getEndDate().toLocalDateTime().getYear() == 9999).collect(Collectors.toList());
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

    public Movie updateMovie(int id, Movie updates) {
        EntityManager em = JPAUtility.getEntityManager();
        EntityTransaction et = null;
        Movie movie = null;
        try {
            et = em.getTransaction();
            et.begin();

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            movie = em.find(Movie.class, id);
            movie.setEndDate(timestamp);
            em.persist(movie);

            et.commit();
            addMovie(updates.getTitle(), updates.getYear(), updates.getRating(), updates.getRunTime());

        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
        return movie;
    }

    // DELETE

    public Movie deleteMovie(int id) {
        EntityManager em = JPAUtility.getEntityManager();
        EntityTransaction et = null;
        Movie movie = null;
        try {
            et = em.getTransaction();
            et.begin();
            movie = em.find(Movie.class, id);
            movie.setDeleted(true);

            em.persist(movie);
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
        return movie;
    }

    public Movie restoreMovie(int id) {
        EntityManager em = JPAUtility.getEntityManager();
        EntityTransaction et = null;
        Movie movie = null;
        try {
            et = em.getTransaction();
            et.begin();
            movie = em.find(Movie.class, id);
            movie.setDeleted(false);

            em.persist(movie);
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
        return movie;
    }

}
