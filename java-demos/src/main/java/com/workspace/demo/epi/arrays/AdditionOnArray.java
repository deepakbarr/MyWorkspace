package com.workspace.demo.epi.arrays;

import com.workspace.demo.epi.Util;

public class AdditionOnArray {

    public static void main(String[] args) {
        int[] nums = {9, 9, 8};

        nums = addOne(nums);

        Util.printArray(nums);

    }

    static int[] addOne(int[] a) {

        int carry = 1;

        for (int i = a.length - 1; i >= 0; i--) {
            int val = carry + a[i];
            carry = val / 10;
            a[i] = val % 10;
            System.out.println("carry = " + carry);
        }
        if (carry > 0)
            a = increaseSize(a);

        return a;
    }

    private static int[] increaseSize(int[] a) {
        int[] b = new int[a.length + 1];
        b[0] = 1;

        for (int i = 1; i < b.length - 1; i++)
            b[i] = a[i - 1];
        return b;
    }
}
