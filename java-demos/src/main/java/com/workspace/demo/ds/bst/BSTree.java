package com.workspace.demo.ds.bst;

/**
 * Created by deepak on 11/7/14.
 */
public class BSTree<T extends Comparable> {

    TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public BSTree() {
        this.root = null;
    }

    public void insert(T element) {
        root=insert(root, element);
    }

    private TreeNode<T> insert(TreeNode<T> root, T data) {
        if (null == root) {
            System.out.println("Inserting");
            root = new TreeNode<T>(data);
        } else if (root.compareTo(data) < 0) {
            root.setLeft(insert(root.getLeft(), data));
        } else {
            root.setRight(insert(root.getRight(), data));
        }
        return root;
    }

    public boolean search() {
        return true;
    }

    public void delete() {
    }

    public void display() {
    }
}
