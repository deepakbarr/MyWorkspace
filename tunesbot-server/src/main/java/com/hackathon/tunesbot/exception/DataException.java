package com.hackathon.tunesbot.exception;

/**
 * Created by deepak.barr on 02/03/16.
 */
public class DataException extends RuntimeException {

  public DataException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataException(String message) {
    super(message);
  }
}
