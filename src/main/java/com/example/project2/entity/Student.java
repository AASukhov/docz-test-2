package com.example.project2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Student {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("group")
    private String group;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDate() {
        return date;
    }

    public String getGroup() {
        return group;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student(Long id, String name, String surname, Date date, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.group = group;
    }
}


