package org.annabelle.domain;

import lombok.Getter;

@Getter
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    public Book(String id, String title, String isbn, String author, String genre) {
        super(id, title);
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

    public static void validateISBN(){

    }

    @Override
    public String getDetails() {
        return "";
    }

    @Override
    public String toCSV() {
        return "";
    }
}
