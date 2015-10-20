package com.workspace.lens.test;


import java.io.IOException;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Created by deepak.barr on 07/10/15.
 */
public class HDFSFileSystem {
  private static String hdfspath = "hdfs://localhost:9000/user/hive/warehouse/dpk_tdest";
//  private static String filepath = "hdfs://localhost:9000/tmp";
//  private static String dirpath = "hdfs://localhost:9000/tmp/queryresult";

  private static String filepath = "/Users/deepak.barr/tmp";
  private static String dirpath = "/Users/deepak.barr/tmp/queryresult";

  public static void main(String[] args) throws IOException, InterruptedException {

    myBugTest();

    Path p = new Path(hdfspath);
    FileSystem fs = p.getFileSystem(getConf());
    System.out.println("fs = " + fs.exists(p));
    FileStatus[] list = fs.listStatus(new Path(hdfspath));

    long purgeInterval = 99 * 60 * 1000;

    for (FileStatus element : list) {
      System.out.println("element.getModificationTime() = " + element.getModificationTime());
      System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
      System.out.println(String.format("%s  = %s    ,    %s  ", element.getPath().toString(), element.isDirectory(),
        new Date(element.getModificationTime())));
      if (System.currentTimeMillis() - element.getModificationTime() > purgeInterval) {
        System.out.println("Delete " + (System.currentTimeMillis() - element.getModificationTime()) / 1000);
      } else System.out.println("Dont delete " + (System.currentTimeMillis() - element.getModificationTime()) / 1000);
//      if(element.isDirectory())
//        fs.delete(element.getPath(),true);
    }
  }

  private static Configuration getConf() {
    Configuration conf = new Configuration();
    conf.addResource(new Path("/Users/deepak.barr/Softwares/hadoop-2.6.0/etc/hadoop/core-site.xml"));
    return conf;
  }

  private static void myBugTest() throws IOException, InterruptedException {
    FileSystem file = new Path(filepath).getFileSystem(new Configuration());
    FileSystem dir = new Path(dirpath).getFileSystem(new Configuration());
    while (true) {
      file.createNewFile(new Path(filepath + "/file-292-" + new Date(System.currentTimeMillis()).toString().replace(" ","_").replace(":",".")));
      System.out.println("File created " + new Date(System.currentTimeMillis()));
      dir.mkdirs(new Path(dirpath + "/dir-292-" + new Date(System.currentTimeMillis()).toString().replace(" ","_").replace(":",".")));
      System.out.println("Dir created " + new Date(System.currentTimeMillis()));
      Thread.sleep(60000);
    }
  }
}
