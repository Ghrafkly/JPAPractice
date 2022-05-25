package com.fdm.oneToOne;

import jakarta.persistence.*;

@Entity
public class BoardGame {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double rating;
    @OneToOne
    private Publisher publisher;

    public BoardGame() {
    }

    public BoardGame(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
