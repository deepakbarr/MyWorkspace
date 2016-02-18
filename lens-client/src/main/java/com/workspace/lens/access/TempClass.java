package com.workspace.lens.access;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak.barr on 17/12/15.
 */
public class TempClass {

  public static void main(String[] args) {


    List<String> prefix = getPrefix();
    List<String> tables = getTableList();
    List<String> filtered=new ArrayList();

    for (String tbl : tables) {

      for (String p : prefix) {
        if (tbl.startsWith(p)) {
          filtered.add(tbl);
          break;
        }
      }
    }

    System.out.println("filtered = " + filtered.size());

    writeToFile(filtered);


  }

  private static void writeToFile(List<String> filtered) {

    BufferedWriter bw = null;
    List<String> tableList = new ArrayList<String>();

    try {
      bw= new BufferedWriter(
        new FileWriter("/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/filtered.txt"));

      System.out.println("Number of tables : " + filtered.size());

      for(String f:filtered)
        bw.write(f+"\n");

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bw != null) bw.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  private static List<String> getPrefix() {
    BufferedReader br = null;
    List<String> tableList = new ArrayList<String>();

    try {
      String sCurrentLine;
      br = new BufferedReader(
        new FileReader("/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/prefix"));
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


  private static List<String> getTableList() {
    BufferedReader br = null;
    List<String> tableList = new ArrayList<String>();

    try {
      String sCurrentLine;
      br = new BufferedReader(
        new FileReader("/Users/deepak.barr/coderep/MyWorkspace/lens-client/src/main/resources/tables"));
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


