package com.workspace.demo.ds;

/**
 * Created by deepak on 11/20/14.
 */
public class Util {

    public static int[] getSortedArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        return arr;
    }

    public static int[] getDummyArray() {


        int[] a = new int[10];

        a[0] = 10;
        a[1] = 2;
        a[2] = 10;
        a[3] = 15;
        a[4] = 4;
        a[5] = 20;
        a[6] = 10;
        a[7] = 1;
        a[8] = 1;
        a[9] = 15;
        return a;

    }

}
