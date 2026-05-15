package org.annabelle.domain;
import lombok.Getter;
import lombok.Setter;
import org.annabelle.utils.Validation;

@Getter
@Setter
public class Book extends Item {
    private String isbn;
    private String author;
    private String genre;

    private static int nextId = 1;

    public Book(String title, String isbn, String author, String genre) {
        super(title);
        this.id = "1" + String.format("%03d", nextId++);
        if (!Validation.validateISBN(isbn)) {
            throw new IllegalArgumentException("invalid isbn");
        }
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public Book(String id, String title, ItemStatus status, String isbn, String author, String genre) {
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
                status + "," +
                isbn + "," +
                author + "," +
                genre;
    }

    @Override
    public String toString() {
        return  id + "|" + title + "|" +
                status + "|" + isbn + "|" + author + "|" + genre;
    }
}
