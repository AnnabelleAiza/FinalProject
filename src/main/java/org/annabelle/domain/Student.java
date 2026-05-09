package org.annabelle.domain;

public class Student extends User {
    @Override
    public boolean canBorrow(Item item) {
        return false;
    }
}
