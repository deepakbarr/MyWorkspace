package com.workspace.demo.ds.stack;

import java.util.*;

/**
 * Created by deepak on 11/30/14.
 */
public class FindSpan {

    public int[] findSpan(int[] arr) {
        int[] span = new int[arr.length];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        span[0] = 1;
        int start = 0;
        int i = 1, n = arr.length;

        while (i < n) {
            if (stack.isEmpty() || stack.top() < arr[   i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                span[top] = stack.isEmpty() ? 1 : top - start + 1;

            }

        }


        return span;
    }


    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 1, 8, 4, 7, 10};

    }

}
