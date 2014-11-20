package com.workspace.demo.ds.dp;

import com.workspace.demo.ds.Util;

/**
 * Created by deepak on 11/20/14.
 */
public class StockStrategy {

    public static int maxProfit(int[] array) {

        int minTillNow = array[0];
        int profit, maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            profit = array[i] - minTillNow;
            if (profit > maxProfit)
                maxProfit = profit;

            if (array[i] < minTillNow)
                minTillNow = array[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = Util.getDummyArray();
        System.out.println("maxProfit(arr) = " + maxProfit(arr));
    }
}
