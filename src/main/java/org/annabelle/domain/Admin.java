package org.annabelle.domain;

public class Admin extends User implements Reportable {
    public Admin(String id, String name) {
        super(id, name);
    }

    public static void generateReport(Library library) {

    }

    public static void backupUsers() {
        //text io writing
    }

    public static void backupItems() {
        //text io writing
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
