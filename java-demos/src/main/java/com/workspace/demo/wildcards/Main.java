package com.workspace.demo.wildcards;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by deepak.barr on 18/2/15.
 */
public class Main {

    public static void main(String[] args) {


        Car car=new Car();
        Bike bike=new Bike();

        Automobile<Car> a1=new Automobile<Car>(car);
        Automobile<Bike> a2=new Automobile<Bike>(bike);


        System.out.println("a2 = " + a2);
        System.out.println("a1 = " + a1);

        List<Car> listCar=new LinkedList<Car>();

        listCar.add(new Car());
        listCar.add(new Car());
        listCar.add(new Car());

        List<Television> listTv=new LinkedList<Television>();

        listTv.add(new Television());
        listTv.add(new Television());
        listTv.add(new Television());

        List<Maruti> listMaruti=new LinkedList<Maruti>();

        listMaruti.add(new Maruti());
        listMaruti.add(new Maruti());
        listMaruti.add(new Maruti());

        List<Object> listObj=new LinkedList<Object>();

        listObj.add(new Object());
        listObj.add(new Object());
        listObj.add(new Object());


        printList(listCar);
        printList(listMaruti);
        printList(listObj);
//        printList(listTv);
//        printList(listTv);
    }

    private static void printList(List<? super Maruti> listCar) {

        for(Object o:listCar) {

            System.out.println("o = " + o);
        }


    }
}
