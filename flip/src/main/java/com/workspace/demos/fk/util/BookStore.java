package com.workspace.demos.fk.util;

import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.exceptions.InvalidBookException;
import com.workspace.demos.fk.exceptions.InvalidSearchException;

import java.util.List;

/**
 * Created by deepak on 12/17/14.
 */
public interface BookStore {
    public List<Book> search(String query) throws InvalidSearchException;
    public boolean insert(Book book) throws InvalidBookException;
    public boolean remove(Book book);
    public long countOfBooks();
}
