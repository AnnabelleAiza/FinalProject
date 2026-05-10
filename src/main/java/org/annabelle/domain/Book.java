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

    public boolean validateISBN(){
        if (isbn == null || isbn.length() != 13) {
            return false;
        }

        for(int i = 0; i < 13; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toCSV() {
        return "";
    }
}
