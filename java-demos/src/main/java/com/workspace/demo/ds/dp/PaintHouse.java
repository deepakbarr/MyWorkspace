package com.workspace.demo.ds.dp;

public class PaintHouse {

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] min = new int[costs.length][n];
        min[0][0] = costs[0][0];
        min[0][1] = costs[0][1];
        min[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            min[i][0] = costs[i][0] + Math.min(min[i - 1][1], min[i - 1][2]);
            min[i][1] = costs[i][1] + Math.min(min[i - 1][0], min[i - 1][2]);
            min[i][2] = costs[i][2] + Math.min(min[i - 1][0], min[i - 1][1]);
        }
        return Math.min(min[n - 1][0], Math.min(min[n - 1][1], min[n - 1][2]));
    }
}
