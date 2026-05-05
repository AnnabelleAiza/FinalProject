package org.annabelle.domain;

public abstract class Item {
    protected String id;
    protected String title;
    protected ItemStatus status;

    public enum ItemStatus{
        IN_STORE, BORROWED, LOST
    }
}
