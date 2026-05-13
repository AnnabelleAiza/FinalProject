package org.annabelle.domain;

import lombok.Getter;

import java.util.List;
@Getter
public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {
        if (!(item instanceof Book)) {
            return false;
        } else if(borrowedItems.size() >= 5) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toCSV() {
        return "STUDENT," +
                id + "," +
                name;
    }
}
