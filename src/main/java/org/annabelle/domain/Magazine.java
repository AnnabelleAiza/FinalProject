package org.annabelle.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Magazine extends Item {
    private String issueNumber;
    private String publisher;

    private static int nextId = 1;

    public Magazine(String title, String issueNumber, String publisher) {
        super(title);
        this.id = "3" + String.format("%03d", nextId++);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public Magazine(String id, String title, String issueNumber, String publisher, ItemStatus status) {
        super(id, title, status);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    @Override
    public String toCSV() {
        return "MAGAZINE" +
                id + "," +
                title + "," +
                issueNumber + "," +
                publisher;
    }
}
