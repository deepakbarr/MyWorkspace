package com.workspace.design.strategy;

/**
 * Created by deepak on 11/4/14.
 */
public class Main {

    public static void main(String[] a) {

        Checker checker=new Checker(new Method1());
        checker.check(10,15);
        checker.check(19,19);
        checker=new Checker(new Method2());
        checker.check(10,15);
        checker.check(19,19);
    }
}
