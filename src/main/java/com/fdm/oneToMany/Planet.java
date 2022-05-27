package com.fdm.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Statement;

@Entity
public class Planet {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private boolean habitable;
    @ManyToOne
    private Star star;

    public Planet() {
    }

    public Planet(String name, boolean habitable) {
        this.name = name;
        this.habitable = habitable;
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

    public boolean isHabitable() {
        return habitable;
    }

    public void setHabitable(boolean habitable) {
        this.habitable = habitable;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", habitable=" + habitable +
                '}';
    }
}
