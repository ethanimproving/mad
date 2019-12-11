package org.improving.mad;

import org.improving.mad.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findAll();
    Movie findById(int id);
}
