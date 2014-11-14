package com.workspace.demo.ds.sort;

import java.util.IdentityHashMap;

/**
 * Created by deepak on 11/14/14.
 */
public class MergeSort {

    public void merge(int[] arr, int start, int mid, int end) {


        int[] left = new int[mid - start + 2];
        int[] right = new int[end - mid + 1];


        int j = 0;
        for (int i = start; i <= mid; i++, j++)
            left[j] = arr[i];


        left[j] = Integer.MAX_VALUE;
        j = 0;


        for (int i = mid + 1; i <= end; i++, j++)
            right[j] = arr[i];

        right[j] = Integer.MAX_VALUE;

        int k = 0;
        j=0;
        for (int i = start; i <= end; i++) {
            if (left[j] < right[k]) {
                arr[i] = left[j];
                j++;
            } else {
                arr[i] = right[k];
                k++;
            }
        }
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        int start = 0, end = arr.length - 1;

        print(arr);
        sort.mergeSort(arr, start, end);
        print(arr);

    }

    private static void print(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");

        System.out.println();
    }

}
