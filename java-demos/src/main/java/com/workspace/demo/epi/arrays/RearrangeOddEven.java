package com.workspace.demo.epi.arrays;

import com.workspace.demo.epi.Util;

public class RearrangeOddEven {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Util.printArray(nums);
        reArrange(nums);
        Util.printArray(nums);
    }

    static void reArrange(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            while (a[i] % 2 == 0)
                i++;
            while (a[j] % 2 == 1)
                j--;

            if (i < j)
                swap(a, i, j);

        }
    }

    static void swap(int[] a, int i, int j) {
        Util.printArray(a);

        System.out.println("i = " + i + " j = " + j);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
