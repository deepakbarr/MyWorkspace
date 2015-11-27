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
//  public final static String QUERY = "msck repair table test_data";

  public final static String QUERY = "show databases";
  public final static String ADDJAR1 =
    "add jar /Users/deepak.barr/Softwares/hive-hive-release-0.13.3-inm/packaging/target/apache-hive-0.13.3-inm-bin/apache-hive-0.13.3-inm-bin/aux_jar/dimlookup-hive-udf-1.0-SNAPSHOT-jar-with-dependencies.jar";
  public final static String ADDJAR2 =
    "add jar /Users/deepak.barr/Softwares/hive-hive-release-0.13.3-inm/packaging/target/apache-hive-0.13.3-inm-bin/apache-hive-0.13.3-inm-bin/aux_jar/json-serde-1.3-SNAPSHOT-jar-with-dependencies.jar";

  public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
    Class.forName("org.apache.hive.jdbc.HiveDriver");
    Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
    System.out.println("Starting test");
    int i = 0, counter = 730;
    Statement stmt = null;
    stmt = con.createStatement();
    int k=0;
    while (i++ < counter) {
        stmt.close();
        con.close();
        con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "", "");
        stmt = con.createStatement();
        System.out.println("iteration = " + ++k);
//      Thread.sleep(3000);
      stmt.execute(ADDJAR1);
      stmt.execute(ADDJAR2);
    }
    stmt.close();
    con.close();
  }
}
