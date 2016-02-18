package com.workspace.client.inheritance;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by deepak.barr on 18/01/16.
 */
public class TestClass {

  public static void main(String[] args)
    throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException,
    InvocationTargetException {
  new TestClass().test3();
  }

  public void test(Class<? super BaseClass> c)
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
    InstantiationException {
    BaseClass b = (BaseClass) Class.forName(c.getName()).getConstructor().newInstance();
    b.method();
  }

  public void test2(Class c)
    throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException,
    IllegalAccessException {
    test(c);
  }

  public void test3() {
    try {
      throw new RuntimeException("RE");
    } catch (Exception e) {
      System.out.println("Handled");
    }
  }
}
