package org.annabelle.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    public Map<String, Item> items;
    public Map<String, User> users;

    public Library() {
        this.items = new TreeMap<>();
        this.users = new TreeMap<>();
    }

    public void borrowItem(String userId, String itemId) {

    }

    public void returnItem(String userId, String itemId) {

    }

    public List<Item> searchByTitle(String title) {

    }

    public List<Item> searchByAuthor(String Author) {

    }

    public Item searchRecursive(){

    }

    public List<Item> searchStream() {

    }
}
