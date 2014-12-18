package com.workspace.demos.fk.exceptions;

/**
 * Created by deepak on 12/15/14.
 */
public class BookDoesNotExistException extends Exception{

    public BookDoesNotExistException(String message) {
        super(message);
    }
}
