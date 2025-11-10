package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Default constructor required by Hibernate
    public StudentEntity() {}

    // Getters and Setters (omitted for brevity but required)
    // Example: public int getId() { return id; }
    //          public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}
