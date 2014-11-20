package com.workspace.demo.ds.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak on 11/18/14.
 */

// http://www.algolist.net/Data_structures/Binary_heap/Insertion
public class Heap {

    List<Integer> array;
    int size;


    public Heap() {
        array = new ArrayList<Integer>();
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public void percolateDown(int idx) {

        int left = 2 * idx;
        int right = 2 * idx + 1;
        int min = idx;

        if (left <= size - 1 && array.get(left) < array.get(min))
            min = left;

        if (right <= size - 1 && array.get(right) < array.get(min))
            min = right;
        if (min != idx) {
            int temp = array.get(min);
            array.set(min, array.get(idx));
            array.set(idx, temp);
            percolateDown(min);
        }
    }

    public void insert(Integer k) {

        if (size == 0) {
            array.add(k);
            size++;
        } else {
            int idx = size++;
            array.add(k);
            percolateUp(idx);
        }
    }

    private void percolateUp(int idx) {
        if (idx == 0)
            return;
        int parent = idx / 2;
        if (array.get(parent) > array.get(idx)) {
            int temp = array.get(parent);
            array.set(parent, array.get(idx));
            array.set(idx, temp);
        }
    }

    public void delete(Integer k) {


    }

    public int deleteMin() {

        int min = array.get(0);
        array.set(0, array.get(size - 1));
        size--;
        percolateDown(0);
        return min;
    }

    public int getMin() {
        return array.get(0);
    }


    public static Heap buildHeap(List<Integer> arr) {
        Heap heap = new Heap();
        heap.setArray(arr);
        heap.setSize(arr.size());

        for (int i = (arr.size() - 1) / 2; i >= 0; i--)
            heap.percolateDown(i);
        return heap;
    }

    public static List<Integer> heapSort(List<Integer> arr) {

        Heap heap = buildHeap(arr);
        System.out.println("heap.size()= " + heap.getSize());
        for (int i = heap.getSize() - 1; i >0; i--) {

            List<Integer> array = heap.getArray();
            int temp = array.get(i);
            array.set(i, array.get(0));
            array.set(0, temp);
            heap.setSize(i);
            heap.percolateDown(0);
        }
        return heap.getArray();
    }


    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Integer> getArray() {
        return array;
    }
}

