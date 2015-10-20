package com.workspace.lens;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Created by deepak.barr on 15/10/15.
 */
public class MyTest {
  public static void main(String[] args) throws IOException {
//    File f=new File("/tmp/a");
//    f.mkdir();
//    f=new File("/tmp/a/b");
//    f.mkdir();

//    File f = new File("/tmp/a");
//    System.out.println("f.delete() = " + f.delete());
    FileSystem fs = new Path("/tmp/a").getFileSystem(new Configuration());
    fs.delete(new Path("/tmp/a"), true);

//    System.out.println("f.list().length = " + f.list().length);

  }
}
