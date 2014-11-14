package com.workspace.demo.ds.LinkedList;

/**
 * Created by deepak on 11/7/14.
 */
public class LLUtil {

    public static void basicOperations(LinkedList<Integer> list) {
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


    public static void reverseLL(LinkedList<Integer> list) {

        print(list);
        System.out.println("After reversing");
        Node<Integer> head = list.getHead();
        Node<Integer> current = head.getNext();

        head.setNext(null);

        Node<Integer> temp;

        while (current != null) {
            temp = current;
            current = current.getNext();
            temp.setNext(head);
            head = temp;
        }
        list.setHead(head);
        print(list);
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
