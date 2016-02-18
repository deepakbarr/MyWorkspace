package com.workspace.demos.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak.barr on 29/12/15.
 */
public class FileUtils {

  public static void writeToFile(String file, List<String> rows, boolean append) {


    System.out.println("Number of rows : " + rows.size());

    BufferedWriter bw = null;
    try {
      bw = new BufferedWriter(new FileWriter(file, append));
      for (String f : rows)
        bw.write(f + "\n");
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


  public static List<String> readFile(String file) {
    BufferedReader br = null;
    List<String> rows = new ArrayList<String>();

    try {
      String sCurrentLine;
      br = new BufferedReader(
        new FileReader(file));
      while ((sCurrentLine = br.readLine()) != null) {
        if (sCurrentLine.length() > 0)
          rows.add(sCurrentLine);
      }
      System.out.println("Number of rows : " + rows.size());

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null) br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      return rows;
    }
  }

  public static long sizeInMB(String file) throws IOException {
    File f = new File(file);
    if (!f.exists())
      f.createNewFile();
    return f.length() / (1024 * 1024);
  }
}
