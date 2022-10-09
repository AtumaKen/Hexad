package com.kelechi.hexad_assesment.models;

import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private int availableCopies;

    public Book(Long id, String title, String author, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        if(availableCopies < 0)
            throw new ProcessingException("Available copies must be a positive value");
        this.availableCopies = availableCopies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if(availableCopies < 0)
            throw new ProcessingException("Available copies must be a positive value");
        this.availableCopies = availableCopies;
    }
}
