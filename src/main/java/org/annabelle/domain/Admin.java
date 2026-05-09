package org.annabelle.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User implements Reportable {
    public Admin(String id, String name) {
        super(id, name);
    }

    public static void generateReport(Library library) {

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
    public boolean canBorrow(Item item) {
        return false;
    }

    @Override
    public String generateReport() {
        return "";
    }
}
