package com.luffy.todo.model;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo { // Renamed to follow Java conventions

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    @Nonnull
    private Long id;

    @Column
    @Nonnull
    private String title; // Fixed typo

    @Column
    @Nonnull
    private Date date;

    @Column
    @Nonnull
    private String status;

    // Default constructor
    public Todo() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() { // Fixed typo in method name
        return title;
    }

    public void setTitle(String title) { // Fixed typo in method name
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

