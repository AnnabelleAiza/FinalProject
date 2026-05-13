package org.annabelle.domain;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public abstract class User {
    protected String id;
    @Setter protected String name;
    @Setter protected List<Item> borrowedItems;

    public static int nextId = 1;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    /**
     * borrows items
     * @param item the item the user wishes to borrow
     */
    public void borrowItem(Item item) {
        if (!borrowedItems.contains(item)) {
            borrowedItems.add(item);
        }
    }

    /**
     * returns items
     * @param item the item the user wishes to return
     */
    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
        }
    }

    public abstract boolean canBorrow(Item item);

    public abstract String toCSV();
}
