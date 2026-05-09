package org.annabelle.domain;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
@Getter
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

    public void borrowItem(Item item, User user) {
        item.setStatus(Item.ItemStatus.BORROWED);
        user.borrowItem(item);
    }

    public void returnItem(Item item, User user) {
        item.setStatus(Item.ItemStatus.IN_STORE);
        user.returnItem(item);
    }

    public List<Item> searchByTitle(String title) {
        Set<Item> results = new HashSet<>();

        for(Item item : items.values()) {
            if(item.getTitle().equalsIgnoreCase(title)) {
                results.add(item);
            }
        }

        return new ArrayList<>(results);
    }

    public List<Item> searchByAuthor(String author) {
        Set<Item> results = new HashSet<>();

        for(Item item : items.values()) {
            if(item instanceof Book) {
                if(item.getTitle().equalsIgnoreCase(author)) {
                    results.add(item);
                }
            }
        }

        return new ArrayList<>(results);
    }

    public Item searchRecursive(List<Item> itemList, String title, int index){
        if(index >= itemList.size()) {
            return null;
        }

        Item current = itemList.get(index);

        if (current.getTitle().equalsIgnoreCase(title)) {
            return current;
        }

        return searchRecursive(itemList, title, index + 1);
    }

    public List<Item> searchStream(String title) {
        return items.values().stream()
                .filter(i -> i.getTitle().equalsIgnoreCase(title))
                .distinct()
                .collect(Collectors.toList());
    }
}
