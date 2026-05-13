package org.annabelle.utils;

public class Validation {
    public static boolean validateISBN(String isbn) {
        if (isbn == null || isbn.length() != 13) {
            return false;
        }

        for(int i = 0; i < 13; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
