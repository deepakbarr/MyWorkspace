package com.workspace.demo.ds.LinkedList;

/**
 * Created by deepak on 10/27/14.
 */
public class LinkedList<T> {

    int size;
    Node<T> head;


    public LinkedList() {
        head = null;
        size = 0;

    }

    public void add(T element) {

        Node temp = new Node<T>(null, element);

        if (head == null) {
            head = temp;
            size++;
            return;

        }
        Node iter = head;
        while (iter.getNext() != null) {
            iter = iter.getNext();
        }
        iter.setNext(temp);
        size++;
    }

    public void remove(int index) throws Exception {

        if (index > size)
            throw new Exception("Can not remove element at index " + index + " for list size of " + size);

        Node current = head;

        int i = 1;
        while (current != null && i++ < index - 1) {
            current = current.getNext();
        }

        System.out.println("***" + current.getData());
        Node temp = current.getNext();
        current.setNext(temp.getNext());
        temp.setNext(null);
        temp.setData(null);
        --size;
    }

    public void add(int index, T data) throws Exception {

        if (index - 1 > size)
            throw new Exception("Can not add element at index " + index + " for list size of " + size);


        Node<T> node = new Node<T>(null, data);

        Node current = head;

        int i = 1;
        while (current != null && i++ < index - 1) {
            current = current.getNext();
        }

        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

}
