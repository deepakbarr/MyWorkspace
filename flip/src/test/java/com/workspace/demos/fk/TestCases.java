package com.workspace.demos.fk;

import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.exceptions.InvalidBookException;
import com.workspace.demos.fk.util.BookStore;
import com.workspace.demos.fk.util.Constants;
import com.workspace.demos.fk.util.DBFactory;
import com.workspace.demos.fk.util.MockDB;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by deepak on 12/15/14.
 */
public class TestCases extends TestCase {

    private static Logger logger = Logger.getLogger(TestCases.class.getName());
    private static BookStore bookStore = null;

    static {
        DBFactory dbFactory = DBFactory.getInstance();
        MockDB db = dbFactory.getDB(Constants.MOCKDB);
        db.clear();

        bookStore = BookStoreMapImpl.getInstance();
        try {
            bookStore.insert(new Book("game of thrones", "martin", 1, 100, 123, null));
            bookStore.insert(new Book("game of shadows", "mr.x", 1, 100, 123, null));
            bookStore.insert(new Book("The Alchemist", "Paulo coelho", 1, 100, 123, null));
            bookStore.insert(new Book("The Zahir", "Paulo coelho", 1, 100, 123, null));

        } catch (InvalidBookException e) {
            logger.info(e.getMessage());
        }
    }

    public TestCases(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestCases.class);
    }

    public void testQuery() {

        try {

            String query = "game thrones";
            List<Book> books = bookStore.search(query);
            if (null == books) {
                System.out.println("No books found matching for query : " + query);
            } else {
                for (Book book : books) {
                    System.out.println(String.format(" %s = %s", book.getTitle(), book.getAuthor()));
                }
            }
            assertEquals(books.size(), 2);
        } catch (Exception e) {
            assertTrue(false);
        }
    }


    public void testQuery2() {
        try {
            String query = "game of";
            List<Book> books = bookStore.search(query);
            assertEquals(books.size(), 2);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public void testQuery3() {
        try {
            String query = "game the";
            List<Book> books = bookStore.search(query);
            assertEquals(books.size(), 4);
        } catch (Exception e) {
            assertTrue(false);
        }
    }


    public void testUpperCaseQuery4() {
        try {
            String query = "gAME";
            List<Book> books = bookStore.search(query);
            assertEquals(books.size(), 2);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public void testQuery4() {
        try {
            String query = "xyz";
            List<Book> books = bookStore.search(query);
            assertTrue(books.size() == 0);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public void testInsertNullBook() {

        try {
            boolean status = bookStore.insert(null);
            assertTrue(!status);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testInsertDuplicateBook() {
        try {
            boolean status = bookStore.insert(new Book("game of thrones", "martin", 1, 100, 123, null));
            assertTrue(!status);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testInvalidQuery() {
        try {
            String query = "";
            List<Book> books = bookStore.search(query);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    public void testRemove1() {

        try {
            bookStore.remove(new Book("game of thrones", "martin", 1, 100, 123, null));
            String query = "game the";
            List<Book> books = bookStore.search(query);
            assertEquals(books.size(), 3);
            bookStore.insert(new Book("game of thrones", "martin", 1, 100, 123, null));
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public void testRemove2() {
        try {
            bookStore.remove(new Book("game of thrnes", "martin", 1, 100, 123, null));
            String query = "game the";
            List<Book> books = bookStore.search(query);
            assertEquals(books.size(), 4);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    public void testSize() {
        try {
            long size = bookStore.countOfBooks();
            assertEquals(size, 4);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    private void printBooks(List<Book> books) {
        if (null == books) {
            System.out.println("No books found");
        } else {
            for (Book book : books) {
                System.out.println(String.format(" %s = %s", book.getTitle(), book.getAuthor()));
            }
        }
    }
}
