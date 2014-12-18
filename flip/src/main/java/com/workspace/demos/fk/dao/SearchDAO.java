package com.workspace.demos.fk.dao;

import com.workspace.demos.fk.beans.Book;

import java.util.List;

/**
 * Created by deepak on 12/15/14.
 */
public interface SearchDAO {
    public void insert(String keyWord, Book book);

    public List<Long> getMatchingBooks(String keyword);

    public void removeBook(long id);
}
