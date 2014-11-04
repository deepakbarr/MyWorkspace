package com.workspace.design.strategy;

/**
 * Created by deepak on 11/4/14.
 */
public class Method1 implements Method {

    String methodName = "Method1";

    public boolean equals(long a, long b) {
        if (a == b)
            return true;
        return false;
    }

    public String getMethodName() {
        return methodName;
    }
}
