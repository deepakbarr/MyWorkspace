package com.workspace.demo.ds.sort;

/**
 * Created by deepak on 11/14/14.
 */
public class BubbleSort {


    public void bubblesort(int arr[]) {

        int n = arr.length;
        boolean swapped = true;

        for (int i = n - 1; i > 0 && swapped; i--) {
            swapped = false;
            System.out.println("Entered here");

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp;
        temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] arr = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        print(arr);
        sort.bubblesort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }
}

