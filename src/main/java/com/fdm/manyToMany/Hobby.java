package com.fdm.manyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hobby {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany (mappedBy = "hobbies")
    private List<Student> students = new ArrayList<>();

    public Hobby() {
    }

    public Hobby(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getTrainees() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainees(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
