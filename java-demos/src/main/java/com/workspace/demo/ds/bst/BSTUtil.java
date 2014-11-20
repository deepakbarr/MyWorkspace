package com.workspace.demo.ds.bst;

import com.workspace.demo.ds.queue.Queue;
import com.workspace.demo.ds.util.BTreePrinter;

/**
 * Created by deepak on 11/7/14.
 */
public class BSTUtil {
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            postOrder(root.getLeft());
            postOrder(root.getRight());
        }
    }

    public static void levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.dequeue();
            System.out.println(temp.getData());
            if (temp.getLeft() != null)
                queue.enqueue(temp.getLeft());
            if (temp.getRight() != null)
                queue.enqueue(temp.getRight());
        }
        System.out.println(queue.isEmpty());
    }


    public static int sizeOfBT(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + sizeOfBT(root.getLeft()) + sizeOfBT(root.getRight());
    }

    public static int sumOfBT(TreeNode root) {
        if (root == null)
            return 0;
        return (Integer) root.getData() + sumOfBT(root.getLeft()) + sumOfBT(root.getRight());
    }

    public static boolean search(TreeNode<Integer> root, int k) {

        if (root == null)
            return false;
        if (root.getData() == k)
            return true;

        if (root.getData() > k)
            return search(root.getLeft(), k);
        else
            return search(root.getRight(), k);
    }

    public static BSTree<Integer> createDummyTree(int n) {

        BSTree<Integer> bst = new BSTree<Integer>();
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(8);
        bst.insert(1);
        bst.insert(10);
        bst.insert(9);
        System.out.println("bst = " + bst.getRoot().getData());
        return bst;
    }

    public static int findMin(TreeNode<Integer> root) {

        if (root.getLeft() == null)
            return root.getData();
        else return findMin(root.getLeft());

    }

    public static int findMax(TreeNode<Integer> root) {
        if (root.getRight() == null)
            return root.getData();
        else return findMax(root.getRight());
    }

    public static TreeNode<Integer> findMaxNode(TreeNode<Integer> root) {
        if (root.getRight() == null)
            return root;
        else return findMaxNode(root.getRight());
    }

    public static boolean areSimilar(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;
        else
            return root1.getData() == root2.getData() && areSimilar(root1.getLeft(), root2.getLeft()) && areSimilar(root1.getRight(), root2.getRight());
    }

    public static boolean subSum(TreeNode<Integer> root, int k) {
        if (root == null)
            return k == 0;
        else {
            k = k - root.getData();
            return subSum(root.getRight(), k) || subSum(root.getLeft(), k);
        }
    }
}
