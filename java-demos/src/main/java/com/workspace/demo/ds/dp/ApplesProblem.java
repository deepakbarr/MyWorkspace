package com.workspace.demo.ds.dp;

import java.security.PublicKey;

/**
 * Created by deepak on 11/25/14.
 */
public class ApplesProblem {

    public int collectMaxApples(int[][] A) {

        int cols = A[0].length;
        int rows = A.length;
        int[][] L = new int[rows + 1][cols + 1];

        for (int i = 0; i <= rows; i++)
            L[i][0] = 0;

        for (int j = 0; j <= cols; j++)
            L[0][j] = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                L[i][j] = A[i - 1][j - 1] + Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[rows][cols];
    }

    public static void main(String[] args) {

        int[][] arr = new int[4][4];

        arr[0] = new int[]{1, 2, 3, 4};
        arr[1] = new int[]{1, 2, 3, 4};
        arr[2] = new int[]{1, 2, 3, 4};
        arr[3] = new int[]{1, 2, 3, 4};
        int apples = new ApplesProblem().collectMaxApples(arr);
        System.out.println("apples = " + apples);
    }
}
