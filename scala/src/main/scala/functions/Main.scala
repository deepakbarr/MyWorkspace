package functions

/**
 * Created by deepak.barr on 09/05/15.
 */
object Main {

  def main(args:Array[String])=
  {
    var f=new Functions();

    var intList:List[Int]=List(1,2,3,4);

    for(element<-intList)
      println(element)

    f.hw("Message sent from main");
  }
}
