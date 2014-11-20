package com.workspace.demo.ds.dp;

/**
 * Created by deepak on 11/20/14.
 */
public class SumContinueousSequence {

    public int maxSum(int[] arr) {

        int sum = 0, maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;
            } else if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = DpUtil.getDummyArray();
        int sum = new SumContinueousSequence().maxSum(a);
        System.out.println("sum = " + sum);
    }
}
