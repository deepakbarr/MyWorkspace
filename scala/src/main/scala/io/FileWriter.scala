package main.scala.io

import java.io.{File, PrintWriter}
import scala.io.Source;

/**
 * Created by deepak.barr on 23/2/15.
 */
object FileWriter {

  def writeFile(n: Int, file: String): Unit = {
    val writer = new PrintWriter(new File(file));
    var i: Int = 0;
    while (i < n) {
      writer.write("Line " + i)
      writer.write("\n")
      i = i + 1;
    }
    writer.close();
  }

  def readFile(file: String): Unit = {
    val lines = Source.fromFile(file).getLines();
    for (line <- lines)
      println(line);
  }

  def main(args: Array[String]): Unit = {

    println("Running FileWriter class...");

    val k = 10;
    val file = "/home/deepak.barr/coderep/MyWorkspace/scala/files/file.txt";
    writeFile(10, file);
    readFile(file)
  }
}
