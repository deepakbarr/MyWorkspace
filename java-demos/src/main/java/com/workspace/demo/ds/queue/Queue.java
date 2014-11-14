package com.workspace.demo.ds.queue;

import com.workspace.demo.ds.LinkedList.Node;

/**
 * Created by deepak on 11/6/14.
 */
public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T element) {

        Node<T> node = new Node<T>(null, element);

        if (head == null) {
            head = tail = node;
            size++;
            return;
        }
        tail.setNext(node);
        tail = node;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Can not dequeue : size " + size());
            return null;
        }
        Node<T> temp = head;
        head = head.getNext();
        --size;
        return temp.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }


    public void print() {

        if (size == 0)
            return;

        Node<T> current = head;

        while (current != null && current != tail) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
    }
}
