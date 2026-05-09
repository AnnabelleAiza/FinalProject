package org.annabelle.domain;

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
}
