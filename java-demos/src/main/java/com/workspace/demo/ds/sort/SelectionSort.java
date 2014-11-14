package com.workspace.demo.ds.sort;

/**
 * Created by deepak on 11/14/14.
 */
public class SelectionSort {

    private void selectionSort(int[] arr) {


    }

    private void swap(int[] arr, int j, int i) {
        int temp;
        temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] arr = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        print(arr);
        sort.selectionSort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }
}
