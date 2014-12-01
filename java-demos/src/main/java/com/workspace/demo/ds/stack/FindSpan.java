package com.workspace.demo.ds.stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by deepak on 11/30/14.
 */
public class FindSpan {

    public int[] findSpan(int[] arr) {
        int[] span = new int[arr.length];

        java.util.Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        span[0] = 1;

        int i = 1, n = arr.length;

        while (i < n) {
        }

        return span;
    }


    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 1, 8, 4, 7, 10};

    }

}
