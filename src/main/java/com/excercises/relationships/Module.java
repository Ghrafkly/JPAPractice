package com.excercises.relationships;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue
    @Column(name = "MODULE_ID")
    private int id;
    @Column(name = "MODULE_NAME")

    private String name;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name="STREAM_MODULE",
            joinColumns =
            @JoinColumn (name="FK_MODULE_ID"),
            inverseJoinColumns=
            @JoinColumn (name="FK_STREAM_ID")
    )
    private List<Stream> streams;

    public Module() {
    }

    public Module(String name, List<Stream> streams) {
        this.name = name;
        this.streams = streams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streams=" + streams +
                '}';
    }
}
