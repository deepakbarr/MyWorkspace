package com.workspace.demos.fk.util;

import com.workspace.demos.fk.beans.Book;

/**
 * Created by deepak on 12/16/14.
 */
public class Validator {

    public static boolean validateBook(Book book) {

        // Can add more checks
        if (book == null || book.getTitle() == null || book.getAuthor() == null || book.getTitle().length() == 0 || book.getAuthor().length() == 0)
            return false;
        return true;
    }

    public static boolean validateQuery(String query) {
        // Can add more checks
        if (query == null || query.length() == 0)
            return false;
        return true;
    }

}
