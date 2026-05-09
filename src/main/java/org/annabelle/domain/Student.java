package org.annabelle.domain;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {
        if (!(borrowedItems instanceof Book)) {
            return false;
        } else if (borrowedItems.size() >= 5) {
            return false;
        } else {
            return true;
        }
    }
}
