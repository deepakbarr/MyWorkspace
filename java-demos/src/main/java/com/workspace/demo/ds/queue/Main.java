package com.workspace.demo.ds.queue;

import com.workspace.demo.ds.LinkedList.Node;

/**
 * Created by deepak on 11/6/14.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> queue = new Queue<Integer>();

        System.out.println("queue.size() = " + queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        queue.print();
        Integer element = queue.dequeue();
        System.out.println("element = " + element);
        queue.print();

        element = queue.dequeue();
        System.out.println("element = " + element);
        queue.print();

        System.out.println("****queue.isEmpty() = " + queue.isEmpty());

        while (true) {
            System.out.println("queue.isEmpty() = " + queue.isEmpty());
            queue.dequeue();
            Thread.sleep(1000);
            queue.print();
        }
    }

}
