package com.workspace.demo.ds.stack;

import com.workspace.demo.ds.LinkedList.Node;

/**
 * Created by deepak on 11/6/14.
 */


public class Stack<T> {

    Node<T> top = null;
    int size = 0;

    public Node<T> getTop() {
        return top;
    }

    public void push(T element) {

        if (top == null) {
            top = new Node<T>(null, element);
            ++size;
            return;
        }

        Node<T> temp = new Node<T>(null, element);
        temp.setNext(top);
        top = temp;
        ++size;
    }

    public T pop() {

        if (isEmpty()) {
            System.out.print("Error : Can not pop - stack size = " + size());
            return null;
        }

        Node<T> temp = top;
        top = top.getNext();
        --size;
        return temp.getData();
    }

    public T top() {
        return top.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
}
