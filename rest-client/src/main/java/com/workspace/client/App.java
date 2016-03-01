package com.workspace.client;

import java.util.*;

public class App {

  public static void main(String[] args) {

    int d1 = 0, d2 = 0;
    for (int i = 0; i < 500; i++) {
      BeanInterface b = test();
      if (b.getAttribute().equals("H_11111"))
        d1++;
      if (b.getAttribute().equals("H_222222"))
        d2++;
    }

    System.out.println("d1 = " + d1);
    System.out.println("d2 = " + d2);
  }

  public static BeanInterface test() {
    Set<BeanInterface> set = new LinkedHashSet<>();

    Bean b1 = new Bean(1, "Hive", "H_11111");
    Bean b2 = new Bean(1, "Hive", "H_222222");
    set.add(b1);
    set.add(b2);
    set.add(new Bean(0, "JDBC", "J1"));
    Collection<BeanInterface> c = Collections.unmodifiableCollection(set);
    List<BeanInterface> newList = new ArrayList<>(c);
    if (Math.random() < 0.4)
      Collections.reverse(newList);
    BeanInterface min = Collections.min(newList, new Comparator<BeanInterface>() {
      @Override
      public int compare(BeanInterface o1, BeanInterface o2) {
        return o1.compareTo(o2);
      }
    });
    System.out.println("b1 = " + b1);
    System.out.println("b2 = " + b2);
    System.out.println("min = " + min);

    return min;
  }
}


class Bean implements BeanInterface {
  public Integer id;
  public String name;
  public String attribute;

  public Bean(Integer id, String name, String attribute) {
    this.id = id;
    this.name = name;
    this.attribute = attribute;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

//  @Override
//  public String toString() {
//    return "Bean{" +
//      "attribute='" + attribute + '\'' +
//      ", name='" + name + '\'' +
//      ", id=" + id +
//      '}';
//  }

  @Override
  public int compareTo(Object o) {
    Bean obj = (Bean) o;
    return this.id.compareTo(obj.getId());
  }

  public void method() {
    System.out.println("BEAN");
  }
}

interface BeanInterface extends Comparable {
  void method();

  String getAttribute();
}