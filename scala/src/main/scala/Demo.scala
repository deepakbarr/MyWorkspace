import java.io.PrintWriter

import java.io._;
import scala.Console;

/**
 * Created by deepak.barr on 17/2/15.
 */

object Demo {

  def main(args: Array[String]) {

    println("Running demo class...");

    var k=10;
    println(square(5));
    method(1);
    val jo=new JavaHW();
    jo.sayHello()
  }
  //Closure

  val square = (x: Int) => x * x;
  //----------------------------------------------------------------------------------------------------------------

  //Functions
  def method(n: Int):Unit= {

    if (n < 10)
      println("n is less than 10");
    else println("n is greater than 10");
    var i = 0;

    while (i < n) {
      println("value : " + i);
      i += 1;
    }
  }
}