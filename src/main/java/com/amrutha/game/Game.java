package com.amrutha.game;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


public class Game {

    public Game() {
    }

    public Game(String id, String title, String genre, String year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String genre;
    private String year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
