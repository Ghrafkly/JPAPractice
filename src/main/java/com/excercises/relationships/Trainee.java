package com.excercises.relationships;

import jakarta.persistence.*;

@NamedQuery(
        name = "findByStream",
        query = "select t from Trainee t where t.stream.name = :streamName"
)
@Entity
public class Trainee {
    @Id
    @GeneratedValue
    @Column(name = "TRAINEE_ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")

    private String lastName;
    @ManyToOne
    @JoinColumn(name = "FK_STREAM_ID")
    private Stream stream;

    public Trainee() {
    }

    public Trainee(String firstName, String lastName, Stream stream) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stream = stream;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
