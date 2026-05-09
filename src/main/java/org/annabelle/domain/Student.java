package org.annabelle.domain;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean canBorrow(Item item) {
        return false;
    }
}
