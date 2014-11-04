package com.workspace.design.adaptor;

/**
 * Created by deepak on 11/4/14.
 */
public class Adaptor {
    public Long sum(String line) {

        String[] tokens = line.split(",");

        long[] values = new long[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            values[i] = Long.parseLong(tokens[i]);
        }
        Adder adder = new Adder();
        return adder.sum(values);
    }
}
