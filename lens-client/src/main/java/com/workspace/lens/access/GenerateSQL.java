package com.workspace.lens.access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak.barr on 29/07/15.
 */
public class GenerateSQL {

  private static String TABLE_FILE = "/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/tables";
  private static String ROLE_PRIVILEGE_QUERY =
    "INSERT INTO ROLE_PRIVILEGE " +
      "(ALLOW_DENY, PRIVILEGE_REGEX, RESOURCE_PATH_REGEX, RESOURCE_TYPE_REGEX, ROLE_ID)" +
      "VALUES('ALLOW','%s','%s','%s',%s);";

  private static String USER_PRIVILEGE_QUERY =
    "INSERT INTO USER_PRIVILEGE " +
      "(ALLOW_DENY, PRIVILEGE_REGEX, RESOURCE_PATH_REGEX, RESOURCE_TYPE_REGEX, USER_ID)" +
      "VALUES('ALLOW','%s','%s','%s',%s);";


  public static void main(String[] args) {
    List<String> tableList = getTableList();

    for (String table : tableList) {
      String regex = Values.DB + "/" + table;
      System.out.println(
        String
          .format(Values.ACCESS_LEVEL==PRIVILEGE.USER?USER_PRIVILEGE_QUERY:ROLE_PRIVILEGE_QUERY, Values.PRIVILEGE_REGEX, regex, Values.RESOURCE_TYPE_REGEX, Values.ID));
    }
  }

  private static List<String> getTableList() {
    BufferedReader br = null;
    List<String> tableList = new ArrayList<String>();

    try {
      String sCurrentLine;
      br = new BufferedReader(new FileReader(TABLE_FILE));
      while ((sCurrentLine = br.readLine()) != null) {
        if (sCurrentLine.length() > 0)
          tableList.add(sCurrentLine);
      }
      System.out.println("Number of tables : " + tableList.size());

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null) br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      return tableList;
    }
  }
}

enum PRIVILEGE {
  USER, ROLE;
}

class Values {
  public static PRIVILEGE ACCESS_LEVEL = PRIVILEGE.USER;
  public static int ID = 2460;
  public static String DB = "bigfoot_dart";
  public static String PRIVILEGE_REGEX = "TABLE_ACCESS";
  public static String RESOURCE_TYPE_REGEX = "TABLE";

}
