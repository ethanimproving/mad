package org.improving.mad.entity;

public class Movie {
    private String title;
    private int year;
    private int rating;
    private String director;
    private int runTime;

    public Movie(String title, int year, int rating, String director, int runTime) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.director = director;
        this.runTime = runTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }
}
