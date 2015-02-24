package collections

/**
 * Created by deepak.barr on 24/2/15.
 */

import Array._

object Arrays {

  def main(args:Array[String]): Unit =
  {
    var arr=Array(1,2,3,4);

    for(element<-arr)
      println(element)


    var c=new Collections();
    c.main(null)

    var sum=0;
    for(i<-0 to (arr.length-1))
      sum+=arr(i);
    println(sum);

    var mat=ofDim[Int](3,3);

    for(i<-0 to 2)
      for(j<-0 to 2) {
      mat(i)(j)=i+j;
        println(mat(i)(j))
      }

  }
}
