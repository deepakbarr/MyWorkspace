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
        root = insert(root, element);
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

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(TreeNode<T> root, T data) {
        if (root == null)
            return false;
        if (root.getData().compareTo(data) == 0) {
            return true;
        } else {

            if (root.getData().compareTo(data) > 0)
                return search(root.getLeft(), data);
            else return search(root.getRight(), data);
        }
    }


    public void delete(T data) {
//        delete(root, data);
    }


//    private TreeNode<T> delete(TreeNode<T> root, T data) {
//
//        if (root == null)
//            return null;
//
//        if (root.getData().compareTo(data) > 0) {
//            return delete(root.getLeft(), data);
//        } else if (root.getData().compareTo(data) < 0) {
//            return delete(root.getRight(), data);
//        } else {
//
//            if (root.getLeft() != null && root.getRight() != null) {
//                TreeNode<Integer> maxLeft = BSTUtil.findMaxNode(root.getLeft());
//
//                T temp=root.getData();
//                root.setData((maxLeft.getData());
//
//            }
//
//        }
//
//    }
//
//}

    public void display() {
    }
}
