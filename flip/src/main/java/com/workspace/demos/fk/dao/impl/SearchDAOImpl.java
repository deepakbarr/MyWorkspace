package com.workspace.demos.fk.dao.impl;

import com.workspace.demos.fk.util.Constants;
import com.workspace.demos.fk.util.DBFactory;
import com.workspace.demos.fk.util.MockDB;
import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.dao.SearchDAO;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by deepak on 12/15/14.
 */
public class SearchDAOImpl implements SearchDAO {

    Logger logger = Logger.getLogger(SearchDAOImpl.class.getName());

    public void insert(String keyword, Book book) {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            long id = db.findIdFromBook(book);
            db.insertBookWithKeyword(keyword, id);
            db.insertKeywordWithBook(id, keyword);
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while inserting book");
        }
    }

    public List<Long> getMatchingBooks(String keyword) {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            List<Long> matchingBookIds = db.findBooksMatchingKeyword(keyword);
            return matchingBookIds;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while getting matching books");
            return null;
        }
    }

    public void removeBook(long id) {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            db.removeBookFromSearchTable(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
