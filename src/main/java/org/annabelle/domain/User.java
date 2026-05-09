package org.annabelle.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public static void borrowItem(Item item) {

    }

    public static void returnItem(Item item) {

    }

    public abstract boolean canBorrow(Item item) {

    }
}
