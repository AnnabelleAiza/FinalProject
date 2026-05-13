package org.annabelle.domain;

public class Teacher extends User {
    public Teacher(String name) {
        super(name);
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
        return id + "," +
                name + "," +
                "TEACHER";
    }
}
