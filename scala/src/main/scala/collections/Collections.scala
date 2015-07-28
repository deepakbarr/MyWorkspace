package collections

/**
 * Created by deepak.barr on 23/2/15.
 */
class Collections {

  def printList(list: List[Int]): Unit = {
    for (element <- list)
      println(element);
  }

  def printSet(set: Set[Int]): Unit = {

    for (element <- set)
      println(set)
  }

  def printMap(map: Map[String, Int]): Unit = {

    for (element <- map.keys) {
      print(element)
      print("---");
      println(map.get(element));
    }
    println("End of print map")
  }

  def main(args: Array[String]): Unit = {

    println("Running Collections class...");
    var x: List[Int] = List(1, 2, 3, 4, 5, 6);
    printList(x)

    var set = Set(1, 2, 3, 4, 5, 6);
    set += 7;

    printSet(set);

    val map = Map("A" -> 1, "B" -> 2, "C" -> 3, "D" -> 4);
    printMap(map);
    println(map)
    println(map.keys)
    println(map.values)
    var map2: Map[String, Int] = Map();
    map2 += ("e" -> 1);
    println(map2)
  }
}
