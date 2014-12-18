package com.workspace.demos.fk.dao;

import com.workspace.demos.fk.beans.Book;
import com.workspace.demos.fk.exceptions.BookDoesNotExistException;
import com.workspace.demos.fk.exceptions.InvalidBookException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by deepak on 12/15/14.
 */
public interface BookDAO {
    public boolean insert(Book book) throws InvalidBookException;

    public Book findBook(long id);

    public Collection<Book> getAllBooks();

    public boolean remove(long id) throws BookDoesNotExistException;

    public List<Book> getBooks(Set<Long> bookIds);

    public long findIdFromBook(Book book);
}
