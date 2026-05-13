package org.annabelle.domain;

import lombok.Getter;

import java.util.List;
@Getter
public class Teacher extends User {
    public Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {
        if(borrowedItems.size() >= 10) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toCSV() {
        return "TEACHER," +
                id + "," +
                name;
    }
}
