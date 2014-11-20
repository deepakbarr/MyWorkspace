package com.workspace.demo.ds.sort;

/**
 * Created by deepak on 11/20/14.
 */
public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        int j, temp;
        for (int i = 1; i < n; i++) {

            temp = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }
    }

    public static void main(String[] args) {

        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 1;
        arr[2] = 9;
        arr[3] = 2;
        arr[4] = 8;
        arr[5] = 3;
        arr[6] = 7;
        arr[7] = 4;
        arr[8] = 6;
        arr[9] = 5;

        InsertionSort insertionSort = new InsertionSort();
        print(arr);
        insertionSort.sort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr)
            System.out.print(value + "  ");
        System.out.println("\n");
    }

}
