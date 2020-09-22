package com.workspace.demo.epi.arrays;

public class MaxProfitStock {

    public static void main(String[] args) {
        int[] nums = {100, 180, 260, 910, 40, 935, 695};
        int profit = maxProfit(nums);
        System.out.println("profit = " + profit);
    }

    static int maxProfit(int[] a) {
        int minSofar = a[0];
        int maxProfit = 0;

        for (int i = 1; i < a.length; i++) {
            int profit = a[i] - minSofar;
            maxProfit = Math.max(maxProfit, profit);
            minSofar = Math.min(minSofar, a[i]);
        }
        return maxProfit;
    }
}
