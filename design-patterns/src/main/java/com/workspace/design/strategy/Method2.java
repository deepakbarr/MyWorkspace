package com.workspace.design.strategy;

/**
 * Created by deepak on 11/4/14.
 */
public class Method2 implements Method {

    String methodName = "Method2";

    public boolean equals(long a, long b) {
        return a == b ? true : false;
    }

    public String getMethodName() {
        return methodName;
    }
}
