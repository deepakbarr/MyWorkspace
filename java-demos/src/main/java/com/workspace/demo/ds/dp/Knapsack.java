package com.workspace.demo.ds.dp;

/**
 * Created by deepak on 11/25/14.
 */
public class Knapsack {

    private static int knapSack(int C, int[] wt, int[] val) {

        int n = val.length;
        int[][] L = new int[n + 1][C + 1];

        for (int i = 0; i <= n; i++)
            L[i][0] = 0;

        for (int w = 0; w <= C; w++)
            L[0][w] = 0;

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= C; w++) {
                if (wt[i - 1] <= w) {
                    L[i][w] = Math.max(val[i-1]+L[i - 1][w - wt[i - 1]], L[i - 1][w]);
                } else L[i][w] = L[i - 1][w];
            }
        }
        return L[n][C];
    }

    public static void main(String[] args) {

        int val[] = {60, 100, 120};
        int wt[] = {20, 2, 30};
        int capacity = 50;
        int maxValue = knapSack(capacity, wt, val);
        System.out.println("maxValue = " + maxValue);
    }
}
