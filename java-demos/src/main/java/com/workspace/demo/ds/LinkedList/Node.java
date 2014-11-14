package com.workspace.demo.ds.LinkedList;

/**
 * Created by deepak on 10/27/14.
 */
public class Node<T> {

    public Node next;
    public T data;

    public Node(Node next, T data) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
