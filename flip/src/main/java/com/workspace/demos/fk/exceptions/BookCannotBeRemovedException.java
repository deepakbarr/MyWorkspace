package com.workspace.demos.fk.exceptions;

/**
 * Created by deepak on 12/16/14.
 */
public class BookCannotBeRemovedException extends Exception {

    public BookCannotBeRemovedException(String message) {
        super(message);
    }
}
