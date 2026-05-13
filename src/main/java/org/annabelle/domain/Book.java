package org.annabelle.domain;

import lombok.Getter;

@Getter
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    private static int nextId = 1;

    public Book(String title, String isbn, String author, String genre) {
        super(title);
        this.id = "1" + String.format("%03d", nextId++);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public Book(String id, String title, String isbn, String author, String genre, ItemStatus status){
        super(id, title, status);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toCSV() {
        return "BOOK," +
                id + "," +
                title + "," +
                author + "," +
                genre;
    }
}
