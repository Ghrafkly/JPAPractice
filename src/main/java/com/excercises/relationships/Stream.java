package com.excercises.relationships;

import jakarta.persistence.*;

@NamedQuery(
        name = "findByStreamName",
        query = "select s from Stream s where s.name = :streamName"
)
@Entity
public class Stream {
    @Id
    @GeneratedValue
    @Column(name = "STREAM_ID")
    private int id;
    @Column(name = "STREAM_NAME")

    private String name;

    public Stream() {
    }

    public Stream(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
