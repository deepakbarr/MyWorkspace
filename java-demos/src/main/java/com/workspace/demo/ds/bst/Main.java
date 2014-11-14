package com.workspace.demo.ds.bst;

import com.workspace.demo.ds.util.BTreePrinter;

/**
 * Created by deepak on 11/7/14.
 */
public class Main {

    public static void main(String[] args) {
        BSTree<Integer> tree = BSTUtil.createDummyTree(10);
//        BTreePrinter.printNode(tree.getRoot());

        System.out.println("Inorder");

        BSTUtil.inOrder(tree.getRoot());
        System.out.println("preorder");
        BSTUtil.preOrder(tree.getRoot());
        System.out.println("postorder");
        BSTUtil.postOrder(tree.getRoot());
        System.out.println("levelorder");
        BSTUtil.levelOrder(tree.getRoot());


        int size = BSTUtil.sizeOfBT(tree.getRoot());
        System.out.println("size = " + size);

        int sum = BSTUtil.sumOfBT(tree.getRoot());
        System.out.println("sum = " + sum);

        System.out.println("BSTUtil.findMin(tree.getRoot()) = " + BSTUtil.findMin(tree.getRoot()));
        System.out.println("BSTUtil.findMax(tree.getRoot()) = " + BSTUtil.findMax(tree.getRoot()));

        boolean flag = BSTUtil.search(tree.getRoot(), 10);
        System.out.println("flag = " + flag);
        flag = BSTUtil.search(tree.getRoot(),100);
        System.out.println("flag = " + flag);
    }
}
