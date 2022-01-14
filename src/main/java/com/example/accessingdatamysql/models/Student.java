package com.example.accessingdatamysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Student {
    @Id // The following attribute will be primary key in our DB
    @GeneratedValue(strategy = GenerationType.AUTO) // Configure auto generated values in the primary key
    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
