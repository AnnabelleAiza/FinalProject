package org.annabelle.domain;

import java.util.*;

public class Library {
    public Map<String, Item> items;
    public Map<String, User> users;

    public Library() {
        this.items = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void addUser(User user){
        users.putIfAbsent(user.getId(), user);
    }

    public void addItem(Item item){
        items.putIfAbsent(item.getId(), item);
    }

    public void borrowItem(String userId, String itemId) {

    }

    public void returnItem(String userId, String itemId) {

    }

    public List<Item> searchByTitle(String title) {
        Set<Item> results = new HashSet<>();

        for(Item item : items.values()) {
            if(item instanceof Book) {
                Book book =
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    results.add(book);
                }
            }
        }

        return new ArrayList<>(results);
    }

    public List<Item> searchByAuthor(String author) {
        Set<Item> results = new HashSet<>();

        for(Item item : items.values()) {
            if(item.getTitle().equalsIgnoreCase(author)) {
                results.add(item);
            }
        }

        return new ArrayList<>(results);
    }

    public Item searchRecursive(){

    }

    public List<Item> searchStream() {

    }
}
