package com.fdm.manyToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name="THINGS_PEOPLE_LIKE",
            joinColumns =
            @JoinColumn (name="FK_STUDENT_ID"),
            inverseJoinColumns=
            @JoinColumn (name="FK_HOBBY_ID")
    )
    private List<Hobby> hobbies = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobbies(Hobby hobby) {
        this.hobbies.add(hobby);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
