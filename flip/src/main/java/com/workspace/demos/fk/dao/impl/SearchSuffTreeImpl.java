package com.workspace.demos.fk.dao.impl;

import com.workspace.demos.fk.util.Constants;
import com.workspace.demos.fk.util.DBFactory;
import com.workspace.demos.fk.util.MockDB;
import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.beans.SuffixTree;
import com.workspace.demos.fk.dao.SearchDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by deepak on 12/16/14.
 */
public class SearchSuffTreeImpl implements SearchDAO {
    @Override
    public void insert(String keyWord, Book book) {
        DBFactory dbFactory = DBFactory.getInstance();
        MockDB db = dbFactory.getDB(Constants.MOCKDB);
        long id = db.findIdFromBook(book);
        SuffixTree suffixTree = new SuffixTree(book.getTitle().toLowerCase());
        db.insertIntoSuffixTreeMap(id, suffixTree);
    }

    @Override
    public List<Long> getMatchingBooks(String keyword) {

        DBFactory dbFactory = DBFactory.getInstance();
        MockDB db = dbFactory.getDB(Constants.MOCKDB);
        Map<Long, SuffixTree> treeMap = db.getSuffixTreeMap();

        List<Long> bookIds = new ArrayList<Long>();
        for (long id : treeMap.keySet()) {
            SuffixTree tree = treeMap.get(id);
            if (tree.search(keyword))
                bookIds.add(id);
        }
        return bookIds;
    }

    @Override
    public void removeBook(long id) {
        DBFactory dbFactory = DBFactory.getInstance();
        MockDB db = dbFactory.getDB(Constants.MOCKDB);
        db.deleteSuffixTree(id);
    }
}
