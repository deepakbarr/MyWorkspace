package com.workspace.demos.fk.dao.impl;

import com.workspace.demos.fk.util.Constants;
import com.workspace.demos.fk.util.DBFactory;
import com.workspace.demos.fk.util.MockDB;
import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.dao.BookDAO;
import com.workspace.demos.fk.exceptions.BookDoesNotExistException;
import com.workspace.demos.fk.exceptions.InvalidBookException;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by deepak on 12/15/14.
 */
public class BookDAOImpl implements BookDAO {

    long id = 0;
    Logger logger = Logger.getLogger(BookDAOImpl.class.getName());

    @Override
    public boolean insert(Book book) throws InvalidBookException {
        if (null == book) throw new InvalidBookException("Invalid Book");
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            boolean status = db.insertBook(book);
            if (!status)
                throw new InvalidBookException(" Duplicate Book");
            return status;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while inserting book");
            return false;
        }
    }

    @Override
    public Book findBook(long id) {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            Book book = db.findBook(id);
            return book;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while inserting book");
            return null;
        }
    }

    @Override
    public long findIdFromBook(Book book) {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            Long id = db.findIdFromBook(book);
            return id;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while inserting book");
            return -1;
        }
    }

    @Override
    public Collection<Book> getAllBooks() {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            Collection<Book> books = db.getAllBooks();
            return books;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while inserting book");
            return null;
        }
    }


    @Override
    public boolean remove(long id) throws BookDoesNotExistException {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            boolean status = db.removeBook(id);
            return status;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while removing book");
            return false;
        }
    }


    public List<Book> getBooks(Set<Long> ids) {

        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            List<Book> list = new ArrayList<Book>();
            Book book;
            for (long id : ids) {
                book = db.findBook(id);
                if (null != book)
                    list.add(book);
            }
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while fetching books");
            return null;
        }
    }
}

