package com.workspace.demos.fk.dao.impl;

import com.workspace.demos.fk.util.BMpatternMatcher;
import com.workspace.demos.fk.util.Constants;
import com.workspace.demos.fk.util.DBFactory;
import com.workspace.demos.fk.util.MockDB;
import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.dao.SearchDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by deepak on 12/16/14.
 */
public class SearchBMImpl implements SearchDAO {

    Logger logger = Logger.getLogger(SearchBMImpl.class.getName());

    @Override
    public void insert(String keyWord, Book book) {
        System.out.println("Do nothing");
    }

    @Override
    public List<Long> getMatchingBooks(String keyword) {
        try {
            DBFactory dbFactory = DBFactory.getInstance();
            MockDB db = dbFactory.getDB(Constants.MOCKDB);
            Map<Long, Book> bookMap = db.getBookMap();
            List<Long> matchingBookIds = new ArrayList<Long>();

            for (long id : bookMap.keySet()) {
                String title = bookMap.get(id).getTitle().toLowerCase();
                if (BMpatternMatcher.match(keyword, title))
                    matchingBookIds.add(id);
            }
            return matchingBookIds;
        } catch (Exception e) {
            logger.info(e.getMessage());
            logger.info("Error occurred while getting matching books");
            return null;
        }
    }

    @Override
    public void removeBook(long id) {
        System.out.println("Do Nothing");
    }
}
