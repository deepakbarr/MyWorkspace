package com.workspace.demo.companies.twitter;

public class MyHashMap {

    private final int size = 100;
    private Node[] nodes;

    public MyHashMap() {
        nodes = new Node[size];
        for (int i = 0; i < size; i++)
            nodes[i] = new Node(-1, -1, null);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node node = findElement(key);
        if (node.next == null)
            node.next = new Node(key, value, null);
        else node.next.val = value;
    }

    private Node findElement(int key) {
        int i = getIndex(key);
        Node n = nodes[i];
        while (n.next != null) {
            if (n.next.key == key)
                return n;
            n = n.next;
        }
        return n;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node node = findElement(key);
        if (node.next == null)
            return -1;
        return node.next.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node n = findElement(key);
        if (n.next != null)
            n.next = n.next.next;
    }

    private int getIndex(int key) {
        return key % size;
    }
}

class Node {
    int key, val;
    Node next;

    public Node(int key, int val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
