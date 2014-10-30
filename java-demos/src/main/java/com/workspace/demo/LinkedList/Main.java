package com.workspace.demo.LinkedList;

import java.util.Iterator;

/**
 * Created by deepak on 10/27/14.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        print(list);

        try {
            System.out.println("After adding element");

            list.add(5, 5);
            print(list);

            System.out.println("After removing element");
            list.remove(7);
            print(list);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static void print(LinkedList<Integer> list) {

        Node<Integer> first = list.getHead();

        while (first != null) {
            System.out.println(first.getData());
            first = first.getNext();
        }

        System.out.println("Size = " + list.getSize());
    }
}
