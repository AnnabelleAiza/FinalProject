package org.annabelle.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public abstract class User {
    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(Item item) {
        if (!borrowedItems.contains(item)) {
            borrowedItems.add(item);
        }
    }

    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
        }
    }

    public abstract boolean canBorrow(Item item);

    public String toCSV() {

    }
}
