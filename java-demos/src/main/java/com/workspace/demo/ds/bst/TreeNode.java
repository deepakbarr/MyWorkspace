package com.workspace.demo.ds.bst;

/**
 * Created by deepak on 11/7/14.
 */
public class TreeNode<T> implements Comparable<T> {

    TreeNode left;
    TreeNode right;
    T data;

    public TreeNode(T data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int compareTo(T o) {
        Integer x, y;
        y = (Integer) data;
        if (o instanceof Integer) {
            x = (Integer) o;
            return x.compareTo(y);
        }
        return -1;
    }
}
