package org.annabelle.domain;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
@Getter
public class Library {
    private Map<String, Item> items = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    public Library() {

    }

    /**
     * adds all the users to the items map
     * @param user all the created users
     */
    public void addUser(User user){
        users.putIfAbsent(user.getId(), user);
    }

    /**
     * adds all the items to the items map
     * @param item all the created items
     */
    public void addItem(Item item){
        items.putIfAbsent(item.getId(), item);
    }

    /**
     * Allows users to borrow items
     * @param item the item that the user wishes to borrow
     * @param user the user that is borrowing the item
     */
    public void borrowItem(Item item, User user) {
        if (item.getStatus() == Item.ItemStatus.IN_STORE && user.canBorrow(item)) {
            item.setStatus(Item.ItemStatus.BORROWED);
            user.borrowItem(item);
        } else {
            System.out.println("cannot borrow");
        }
    }

    /**
     * Allows users to return items
     * @param item the item that the user wishes to return
     * @param user the user that is returning the item
     */
    public void returnItem(Item item, User user) {
        if (item.getStatus() == Item.ItemStatus.BORROWED || item.getStatus() == Item.ItemStatus.LOST) {
            item.setStatus(Item.ItemStatus.IN_STORE);
            user.returnItem(item);
        } else {
            System.out.println("cannot return");
        }
    }

    /**
     * searches for items based on title
     * @param title the input title
     * @return A list of items with that title
     */
    public List<Item> searchByTitle(String title) {
        Set<Item> results = new HashSet<>();

        for(Item item : items.values()) {
            if(item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(item);
            }
        }

        return new ArrayList<>(results);
    }

    /**
     * searches for books based on authors
     * @param author the author of the book that we are searching for
     * @return A list of the books that are written by said author
     */
    public List<Item> searchByAuthor(String author) {
        Set<Item> results = new HashSet<>();

        for(Item item : items.values()) {
            if(item instanceof Book) {
                if(((Book) item).getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    results.add(item);
                }
            }
        }

        return new ArrayList<>(results);
    }

    /**
     * Searches for items based on title using recursion
     * @param itemList list of items
     * @param title the input title
     * @param index the index in the itemList
     * @return the current items in the itemList
     */
    public Item searchRecursive(List<Item> itemList, String title, int index){
        if(index >= itemList.size()) {
            return null;
        }

        Item current = itemList.get(index);

        if (current.getTitle().toLowerCase().contains(title.toLowerCase())) {
            return current;
        }

        return searchRecursive(itemList, title, index + 1);
    }

    /**
     * searches for items based on title using stream
     * @param title the input title
     * @return A list of items
     */
    public List<Item> searchStream(String title) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(title.toLowerCase()))
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Reads the users from the CSV file
     */
    private void loadUsersFromCSV() {
        File file = new File(Constants.USER_CSV_PATH);
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] parts = str.split(",");

                String id = parts[0];
                String name = parts[1];
                String type = parts[2];

                User user;

                if(type.equals("STUDENT")) {
                    user = new Student(id, name);
                } else if (type.equals("TEACHER")) {
                    user = new Teacher(id, name);
                } else {
                    user = new Admin(id, name);
                }

                addUser(user);
            }
        } catch (IOException e) {
            System.out.println("reading error");
        }
    }

    /**
     * Reads the items from the CSV file
     */
    private void loadItemsFromCSV() {
        File file = new File(Constants.ITEM_CSV_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] parts = str.split(",");
                String type = parts[0];

                Item item = null;
                switch (type) {
                    case "BOOK" ->item = new Book(parts[1],parts[2],parts[3],parts[4],parts[5]);
                    case "DVD" -> item = new DVD(parts[1],parts[2],parts[3],Integer.parseInt(parts[4]));
                    case "MAGAZINE" -> item = new Magazine(parts[1],parts[2],parts[3],parts[4]);
                    default -> {
                        System.out.println("unknown");
                        continue;
                    }
                }

                addItem(item);
            }
        } catch (IOException e) {
            System.out.println("reading error");
        }
    }
}
