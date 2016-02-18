package com.workspace.lens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 */
class MyException extends Exception
{
  public MyException(String msg) {
    super(msg);
  }
}

class MyException2 extends Exception
{
  public MyException2(String msg) {
    super(msg);
  }
}

public class App {
  public static void main(String[] args) throws Exception {

    try {

      throw new MyException("myexp");
    } catch (MyException e) {
      System.out.println(e.getMessage());
      throw new MyException2("myexp2");
    } catch (Exception e) {
      System.out.println("AAA");
    }
  }
}

