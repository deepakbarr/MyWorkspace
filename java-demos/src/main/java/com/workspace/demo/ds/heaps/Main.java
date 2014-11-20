package com.workspace.demo.ds.heaps;

import java.util.List;

/**
 * Created by deepak on 11/19/14.
 */
public class Main {
    public static void main(String[] args) {
        Heap heap = HeapUtil.createDummyHeap();
        System.out.println("heap.getMin() = " + heap.getMin());
        System.out.println("heap.size = " + heap.getSize());

        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());


        List<Integer> list = HeapUtil.getDummyList();

        heap = Heap.buildHeap(list);

        System.out.println("heap.getMin() = " + heap.getMin());
        System.out.println("heap.size = " + heap.getSize());

        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());
        System.out.println("heap.deleteMin() = " + heap.deleteMin());


        list = HeapUtil.getDummyList();

        print(list);
        list = Heap.heapSort(list);
        print(list);


    }

    private static void print(List<Integer> list) {

        for (int value : list)
            System.out.print(value + "  ");

        System.out.println("\n");

    }
}
