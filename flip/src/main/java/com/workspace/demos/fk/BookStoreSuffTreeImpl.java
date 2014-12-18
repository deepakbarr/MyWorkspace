package com.workspace.demos.fk;

import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.dao.BookDAO;
import com.workspace.demos.fk.dao.SearchDAO;
import com.workspace.demos.fk.dao.impl.BookDAOImpl;
import com.workspace.demos.fk.dao.impl.SearchSuffTreeImpl;
import com.workspace.demos.fk.exceptions.BookCannotBeRemovedException;
import com.workspace.demos.fk.exceptions.BookNotInsertedException;
import com.workspace.demos.fk.exceptions.InvalidBookException;
import com.workspace.demos.fk.exceptions.InvalidSearchException;
import com.workspace.demos.fk.util.BookStore;
import com.workspace.demos.fk.util.Validator;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by deepak on 12/15/14.
 */
public class BookStoreSuffTreeImpl implements BookStore {

    private Logger logger = Logger.getLogger(BookStoreSuffTreeImpl.class.getName());
    private static BookStoreSuffTreeImpl bookStore = null;

    private BookStoreSuffTreeImpl() {
    }

    public static BookStoreSuffTreeImpl getInstance() {
        if (null == bookStore) {
            bookStore = new BookStoreSuffTreeImpl();
        }
        return bookStore;
    }

    public List<Book> search(String query) throws InvalidSearchException {

        if (!Validator.validateQuery(query))
            throw new InvalidSearchException("Invalid Search");
        String[] keywords = query.toLowerCase().split(" ");
        return search(keywords);
    }

    /**
     * Finds books matching with each keyword from search database and pull the matching books from book database
     *
     * @param keywords
     * @return
     */
    private List<Book> search(String[] keywords) {

        try {
            SearchDAO searchDAO = new SearchSuffTreeImpl();
            BookDAO bookDAO = new BookDAOImpl();
            Set<Long> matchingBookIds = new HashSet();
            for (String keyword : keywords) {
                if (keyword.length() == 0)
                    continue;

                List<Long> list = searchDAO.getMatchingBooks(keyword.toLowerCase());

                if (null != list) {
                    matchingBookIds.addAll(list);
                }
            }
            List<Book> matchingBooks = bookDAO.getBooks(matchingBookIds);
            return matchingBooks;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred when searching the book database");
            return null;
        }
    }

    /**
     * Insert into book database as well as search database
     *
     * @param book
     * @throws com.workspace.demos.fk.exceptions.InvalidBookException
     */
    public boolean insert(Book book) throws InvalidBookException {

        try {
            BookDAO bookDao = new BookDAOImpl();
            if (!Validator.validateBook(book))
                throw new InvalidBookException("Invalid Book");

            if (!bookDao.insert(book)) {
                throw new BookNotInsertedException("Book can not be inserted");
            }
            String[] keywords = book.getTitle().toLowerCase().split(" ");
            SearchDAO searchDAO = new SearchSuffTreeImpl();
            for (String keyword : keywords) {
                searchDAO.insert(keyword, book);
            }
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean remove(Book book) {

        try {
            BookDAO bookDao = new BookDAOImpl();
            if (!Validator.validateBook(book))
                throw new InvalidBookException("Invalid Book");

            long id = bookDao.findIdFromBook(book);

            if (id == -1)
                throw new BookCannotBeRemovedException("Book does not exist");

            if (!bookDao.remove(id)) {
                throw new BookCannotBeRemovedException("Book can not be removed");
            }
            SearchDAO searchDAO = new SearchSuffTreeImpl();
            searchDAO.removeBook(id);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public long countOfBooks() {
        BookDAO dao = new BookDAOImpl();
        Collection<Book> books = dao.getAllBooks();
        return books.size();
    }
}