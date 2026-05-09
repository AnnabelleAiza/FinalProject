package org.annabelle.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Magazine extends Item {
    private String issueNumber;
    private String publisher;

    public Magazine(String id, String title, String issueNumber, String publisher) {
        super(id, title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
}
