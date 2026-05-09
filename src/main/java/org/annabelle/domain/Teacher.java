package org.annabelle.domain;

public class Teacher extends User {
    @Override
    public boolean canBorrow(Item item) {
        return false;
    }
}
