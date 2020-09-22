package com.workspace.demo.epi.arrays;

import com.workspace.demo.epi.Util;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7};
        Util.printArray(nums);
        removeDups(nums);
    }

    static void removeDups(int[] a) {
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                i++;
                a[i] = a[j];
            }
        }
        Util.printArray(a, i);
    }
}
