package com.workspace.demo.ds.bst;

import com.workspace.demo.ds.Util;
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

        int depth = BSTUtil.depth(tree.getRoot());
        System.out.println("depth = " + depth);

        System.out.println("BSTUtil.isBalanced(root) = " + BSTUtil.isBalanced(tree.getRoot()));


        int sum = BSTUtil.sumOfBT(tree.getRoot());
        System.out.println("sum = " + sum);

        System.out.println("BSTUtil.findMin(tree.getRoot()) = " + BSTUtil.findMin(tree.getRoot()));
        System.out.println("BSTUtil.findMax(tree.getRoot()) = " + BSTUtil.findMax(tree.getRoot()));

        boolean flag = BSTUtil.search(tree.getRoot(), 10);
        System.out.println("flag = " + flag);
        flag = BSTUtil.search(tree.getRoot(), 100);
        System.out.println("flag = " + flag);

        BSTree<Integer> tree2 = BSTUtil.createDummyTree(10);

        System.out.println("BSTUtil.areSimilar(null,null) = " + BSTUtil.areSimilar(null, null));
        System.out.println("BSTUtil.areSimilar(null,tree) = " + BSTUtil.areSimilar(null, tree.getRoot()));
        System.out.println("BSTUtil.areSimilar(1,2) = " + BSTUtil.areSimilar(tree.getRoot(), tree2.getRoot()));

        System.out.println("sum=11 = " + BSTUtil.subSum(tree.getRoot(), 11));
        System.out.println("sum=11 = " + BSTUtil.subSum(tree.getRoot(), 55));
        System.out.println("tree.search(8) = " + tree.search(8));
        System.out.println("tree.search(11) = " + tree.search(11));
        System.out.println("tree.search(11) = " + tree.search(10));

        System.out.println("*************************** BUILD TREE ****************");
        int[] arr = Util.getSortedArray(16);
        System.out.println("arr = " + arr.length);
        TreeNode<Integer> root = BSTUtil.buildTree(arr, 0, arr.length - 1);
        BSTUtil.inOrder(root);
        System.out.println("BSTUtil.sizeOfBT(root) = " + BSTUtil.sizeOfBT(root));
        depth = BSTUtil.depth(root);

        System.out.println("depth = " + depth);
        System.out.println("BSTUtil.isBalanced(root) = " + BSTUtil.isBalanced(root));
    }
}
