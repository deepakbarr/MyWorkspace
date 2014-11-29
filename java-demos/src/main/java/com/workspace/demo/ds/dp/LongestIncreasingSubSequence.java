package com.workspace.demo.ds.dp;

/**
 * Created by deepak on 11/25/14.
 */
public class LongestIncreasingSubSequence {

    private int lis(int[] arr) {

        int n = arr.length;
        int[] L = new int[n];

        for (int i = 0; i < n; i++)
            L[i] = 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && L[i] < L[j] + 1)
                    L[i] = L[j] + 1;
            }
            if (max < L[i])
                max = L[i];
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        int len = new LongestIncreasingSubSequence().lis(arr);

        System.out.println("len = " + len);
    }
}
