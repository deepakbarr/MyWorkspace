package com.workspace.demos.test;

import java.io.IOException;
import java.util.List;

import com.workspace.demos.util.FileUtils;

/**
 * Created by deepak.barr on 29/12/15.
 */
public class CreateTestData {

  static final long size_mb = 150;
  static final String input = "/Users/deepak.barr/coderep/MyWorkspace/flipkart-stuff/src/main/resources/test_data.csv";
  static final String output =
    "/Users/deepak.barr/coderep/MyWorkspace/flipkart-stuff/src/main/resources/test_data_big2.csv";

  public static void main(String[] args) throws IOException {
    System.out.println("Started");
    while (size_mb > FileUtils.sizeInMB(output)) {
      List<String> rows = FileUtils.readFile(input);
      FileUtils.writeToFile(output, rows, true);
      System.out.println("FileUtils.sizeInMB(output = " + FileUtils.sizeInMB(output));
    }
    System.out.println("Finished");
  }

}
