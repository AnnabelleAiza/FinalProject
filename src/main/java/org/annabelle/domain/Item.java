package org.annabelle.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public abstract class Item {
    protected String id;
    protected String title;
    protected ItemStatus status;

    public Item(String title) {
        this.title = title;
        this.status = ItemStatus.IN_STORE;
    }

    public abstract String toCSV();

    public enum ItemStatus{
        IN_STORE, BORROWED, LOST
    }
}
