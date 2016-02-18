package com.workspace.lens.test.hive;

import java.sql.*;

/**
 * Created by deepak.barr on 07/09/15.
 */
public class HiveSessionCloseTest {
//  public final static String QUERY = "select count(*) count from default.test_data";
  public final static String QUERY = "select name,count(*) count from default.test_data group by name";
  public final boolean SUBMITTED=false;

  public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
    Class.forName("org.apache.hive.jdbc.HiveDriver");
    Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
    System.out.println("Starting test");
    Statement stmt = con.createStatement();
    stmt.close();
    con.close();
    con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
    stmt = con.createStatement();

    Thread t=new Thread(new Process(stmt,QUERY));
    t.start();
    Thread.sleep(3000);
    System.out.println("Closing conn");
    stmt.close();
    con.close();
    System.out.println("Closed conn");
  }

  static class Process implements Runnable
  {
    Statement statement;
    String query;
    public Process(Statement stmt, String query) {
      this.statement=stmt;
      this.query=query;
    }

    @Override
    public void run() {
      try {
        System.out.println("Submitting " +query);
        statement.execute(query);
        System.out.println("Results have come");
//        if(rs.next())
//          System.out.println("rs.getLong(1) = " + rs.getLong(1));
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

}
