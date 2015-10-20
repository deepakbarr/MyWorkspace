package com.workspace.lens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by deepak.barr on 07/09/15.
 */
public class HiveTest {
  //  public final static String QUERY = "drop table ddddd";
//  public final static String QUERY = "CREATE TEMPORARY FUNCTION dummy_function AS 'dummy.class.name'";
   public final static String QUERY="msck repair table dkjfk";

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("org.apache.hive.jdbc.HiveDriver");
    Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
    System.out.println("Starting test");
    int i = 0, counter = 1000;
    Statement stmt = null;
    while (i++ < counter) {
      try {
        if (i % 100 == 0)
          System.out.println("iteration = " + i);
        stmt = con.createStatement();
//        stmt.executeUpdate(QUERY);
        stmt.executeQuery(QUERY);
      } catch (Exception e) {
//        System.out.println(e.getMessage());
     }
      finally {
        stmt.close();
      }
    }
    con.close();
  }
}
