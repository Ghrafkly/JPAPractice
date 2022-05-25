package com.fdm.JBDCDemo;

public class Movie {
    private int id;
    private String name;
    private double ticketPrice;

    public Movie() {
        super();
    }

    public Movie(int id, String name, double ticketPrice) {
        this.id = id;
        this.name = name;
        this.ticketPrice = ticketPrice;
    }

    public Movie(String name, double ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
