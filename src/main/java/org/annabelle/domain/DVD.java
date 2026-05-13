package org.annabelle.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DVD extends Item {
    private String director;
    private int durationMinutes;

    private static int nextId = 1;

    public DVD(String title, String director, int durationMinutes) {
        super(title);
        this.id = "2" + String.format("%03d", nextId++);
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public DVD(String id, String title, String director, int durationMinutes, ItemStatus status) {
        super(id, title, status);
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toCSV() {
        return "DVD" +
                id + "," +
                title + "," +
                director + "," +
                durationMinutes;
    }
}
