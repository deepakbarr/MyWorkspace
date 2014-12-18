package com.workspace.demos.fk.beans;

/**
 * Created by deepak on 12/16/14.
 */
public class SuffixTree {
    Node root;

    public SuffixTree(String s) {
        this.root = new Node('0');
        insertSuffix(s);
    }

    private void insertSuffix(String s) {
        for (int i = 0; i < s.length(); i++) {
            insert(s, i);
        }
    }

    private void insert(String s, int index) {
        Node curr = root;
        char c;
        for (int i = index; i < s.length(); i++) {

            c = s.charAt(i);
            if (!curr.childrenHas(c)) {
                curr.addToChildren(c);
            }
            curr = curr.getChildren(c);
        }
        curr.isEnd(true);
    }

    public boolean search(String p) {
        Node curr = root;
        char c;
        int i = 0;
        while (i < p.length()) {
            c = p.charAt(i);
            if (!curr.childrenHas(c))
                return false;
            curr = curr.getChildren(c);
            i++;
        }
        return true;
    }
}
