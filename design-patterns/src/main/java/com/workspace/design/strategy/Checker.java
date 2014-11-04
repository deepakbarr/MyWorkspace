package com.workspace.design.strategy;

/**
 * Created by deepak on 11/4/14.
 */
public class Checker {
    Method method;

    public Checker(Method method) {
        this.method = method;
    }

    public void check(long a, long b) {
        if (method.equals(a, b))
            System.out.println("Using " + method.getMethodName() + " Equal");
        else System.out.println("Using " + method.getMethodName() + " Not Equal");
    }
}
