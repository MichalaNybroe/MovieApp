package com.example.demomedtine.repositories;

public class Movie {
    private String title;
    private String year;
    private int length;
    private String subject;
    private int popularity;
    private String awards;

    public Movie(String title, String year, int length, String subject, int popularity, String awards) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String isAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return title + " " + year + " " + length + " " + subject + " " + popularity + " " + awards;
    }
}
