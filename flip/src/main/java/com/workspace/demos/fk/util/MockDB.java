package com.workspace.demos.fk.util;

import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.beans.SuffixTree;

import java.util.*;

/**
 * Created by deepak on 12/16/14.
 */
public enum MockDB {

    INSTANCE;
    private Map<Long, Book> bookMap = new HashMap<Long, Book>();
    private Map<String, List<Long>> keywordToIdMap = new HashMap();
    private Map<Long, List<String>> idToKeywordMap = new HashMap();
    private Map<Long, SuffixTree> idToSuffixTreeMap = new HashMap<Long, SuffixTree>();
    private long id = 0;

    public boolean insertBook(Book book) {
        if (findIdFromBook(book) == -1) {
            bookMap.put(++id, book);
            return true;
        }
        return false;
    }

    public Book findBook(long id) {
        return bookMap.get(id);
    }

    public Collection<Book> getAllBooks() {
        Collection<Book> books = bookMap.values();
        return books;
    }

    public boolean removeBook(long id) {
        Book book = bookMap.remove(id);
        if (null == book)
            return false;
        return true;
    }

    public List<Long> findBooksMatchingKeyword(String keyword) {
        List<Long> list = keywordToIdMap.get(keyword);
        return list;
    }

    public void insertBookWithKeyword(String keyword, long id) {
        List<Long> bookIds = keywordToIdMap.get(keyword);

        if (null == bookIds) {
            bookIds = new ArrayList<Long>();
            keywordToIdMap.put(keyword, bookIds);
        }
        bookIds.add(id);
    }

    public void insertKeywordWithBook(long id, String keyword) {
        List<String> keywordList = idToKeywordMap.get(id);
        if (null == keywordList) {
            keywordList = new ArrayList<String>();
            idToKeywordMap.put(id, keywordList);
        }
        keywordList.add(keyword);
    }

    public long findIdFromBook(Book book) {
        Book b;
        for (long id : bookMap.keySet()) {
            b = bookMap.get(id);
            if (b.equals(book))
                return id;
        }
        return -1;
    }

    public void removeBookFromSearchTable(long id) {
        List<String> keywords = idToKeywordMap.get(id);
        idToKeywordMap.remove(id);

        for (String keyword : keywords) {
            List<Long> ids = keywordToIdMap.get(keyword);
            ids.remove(id);
            if (ids.size() == 0)
                keywordToIdMap.remove(keyword);
        }
    }

    public void insertIntoSuffixTreeMap(long id, SuffixTree suffixTree) {
        idToSuffixTreeMap.put(id, suffixTree);
    }

    public Map<Long, SuffixTree> getSuffixTreeMap() {
        return idToSuffixTreeMap;
    }

    public void deleteSuffixTree(long id) {
        idToSuffixTreeMap.remove(id);
    }

    public Map<Long, Book> getBookMap() {
        return bookMap;
    }

    public void clear() {

        idToSuffixTreeMap.clear();
        bookMap.clear();
        keywordToIdMap.clear();
        idToKeywordMap.clear();
        id = 0;
    }
}
