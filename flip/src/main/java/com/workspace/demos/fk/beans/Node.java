package com.workspace.demos.fk.beans;

/**
 * Created by deepak on 12/16/14.
 */
public class Node {

    private char c;
    private boolean end;
    private Node[] children;

    public Node(char c) {
        this.c = c;
        this.children = new Node[256];
    }

    public boolean childrenHas(char c) {
        if (children[c] != null)
            return true;
        return false;
    }

    public char getData() {
        return c;
    }

    public void addToChildren(char c) {
        children[c] = new Node(c);
    }

    public Node getChildren(char c) {
        return children[c];
    }

    public void isEnd(boolean flag) {
        end = flag;
    }
}
