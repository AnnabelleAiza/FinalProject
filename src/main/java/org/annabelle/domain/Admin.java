package org.annabelle.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Admin extends User implements Reportable {
    public Admin(String id, String name) {
        super(id, name);
    }

    public void backupUsers(Library library) {
        File file = new File(Constants.USER_CSV_PATH);
        try (FileWriter fw = new FileWriter(file)) {
            for(User user : library.getUsers().values()) {
                fw.write(user.toCSV());
                fw.write("\n");
            }
        } catch (IOException e) {
            System.out.println("writing error");
        }
    }

    public void backupItems(Library library) {
        File file = new File(Constants.ITEM_CSV_PATH);
        try (FileWriter fw = new FileWriter(file)) {
            for(Item item : library.getItems().values()) {
                fw.write(item.toCSV());
                fw.write("\n");
            }
        } catch (IOException e) {
            System.out.println("writing error");
        }
    }

    @Override
    public Map<Item.ItemStatus, List<Item>> generateReport(Library library) {
        Map<Item.ItemStatus, List<Item>> map = new TreeMap<>();

        for(Item item : library.getItems().values()) {
            map.putIfAbsent(item.getStatus(), new ArrayList<>());
            map.get(item.getStatus()).add(item);
        }

        return map;
    }

    @Override
    public String toCSV() {
        return id + "," +
                name + "," +
                "ADMIN";
    }

    @Override
    public boolean canBorrow(Item item) {
        return false;
    }
}
