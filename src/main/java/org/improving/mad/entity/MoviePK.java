package org.improving.mad.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class MoviePK implements Serializable {
    protected int movieId;
    protected Timestamp startDate;

    public MoviePK() {}

    public MoviePK(int movieId, Timestamp startDate) {
        this.movieId = movieId;
        this.startDate = startDate;
    }
}
