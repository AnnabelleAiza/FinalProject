package org.annabelle.domain;

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

    public static void validateISBN(){

    }
}
