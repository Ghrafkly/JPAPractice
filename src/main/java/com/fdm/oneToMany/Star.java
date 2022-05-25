package com.fdm.oneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Star {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String cat;

    @OneToMany(mappedBy = "star", cascade = CascadeType.PERSIST)
    private List<Planet> planets = new ArrayList<>();

    public Star() {
    }

    public Star(String name, String cat) {
        this.name = name;
        this.cat = cat;
    }

    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cat='" + cat + '\'' +
                '}';
    }
}
