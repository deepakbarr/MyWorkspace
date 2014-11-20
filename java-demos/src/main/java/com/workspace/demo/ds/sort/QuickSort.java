package com.workspace.demo.ds.sort;

/**
 * Created by deepak on 11/19/14.
 */
public class QuickSort {

    public int partition(int[] arr, int p, int q) {
        int pivot = q;
        int i = p - 1;

        for (int j = p; j <=q - 1; j++) {
            if (arr[j] < arr[pivot]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, q);
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quicksort(int[] arr, int p, int q) {
        if (p < q) {
            int k = partition(arr, p, q);
            quicksort(arr, p, k - 1);
            quicksort(arr, k + 1, q);
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

        QuickSort sort = new QuickSort();

        print(arr);
        sort.quicksort(arr, 0, arr.length-1);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int value : arr)
            System.out.print(value + "  ");
        System.out.println("\n");
    }
}
