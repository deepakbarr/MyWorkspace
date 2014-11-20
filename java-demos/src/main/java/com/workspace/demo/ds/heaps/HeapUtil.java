package com.workspace.demo.ds.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak on 11/19/14.
 */
public class HeapUtil {

    public static Heap createDummyHeap() {

        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(1);
        heap.insert(9);
        heap.insert(2);
        heap.insert(8);
        heap.insert(3);
        heap.insert(7);
        heap.insert(4);
        heap.insert(6);
        heap.insert(5);
        return heap;
    }

    public static List<Integer> getDummyList() {

        List<Integer> arrayList=new ArrayList<Integer>();

        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(5);
        return arrayList;
    }
}
