package org.annabelle.domain;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Item {
    protected String id;
    protected String title;
    protected ItemStatus status;

    public Item(String title) {
        this.title = title;
        this.status = ItemStatus.IN_STORE;
    }

    public Item(String id, String title, ItemStatus status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public abstract String toCSV();

    public enum ItemStatus{
        IN_STORE, BORROWED, LOST
    }

    @Override
    public String toString() {
        return id + "|" + title + "|" + status;
    }
}
