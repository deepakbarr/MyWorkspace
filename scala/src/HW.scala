/**
 * Created by deepak.barr on 17/2/15.
 */

/**
 * Created by deepak.barr on 17/2/15.
 */

object HW {

  def m2(name:String):String = {
    name+" returned";
  }

  def main(args: Array[String]) {

    println(args{0});
    method(1);
    val out=m2("dee");
    println(out)
    println("Hello, world!")
  }

def method(n: Int)
{

  println("In method");

  if(n<10)
    println("n is less than 10");
  else println("n is greater than 10");
  var i=0;

  while(i<n) {
    println("value : " + i);
    i += 1;
  }
}
}