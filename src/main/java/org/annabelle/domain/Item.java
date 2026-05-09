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

    public Item(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public enum ItemStatus{
        IN_STORE, BORROWED, LOST
    }
}
