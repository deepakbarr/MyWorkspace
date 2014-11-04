package com.workspace.design.adaptor;

/**
 * Created by deepak on 11/4/14.
 */
public class Adder {

    public long sum(long[] arr) {
        long sum = 0;
        for (long value : arr)
            sum += value;
        return sum;
    }
}
