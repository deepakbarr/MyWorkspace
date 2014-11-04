package com.workspace.design.adaptor;

import java.util.Random;

/**
 * Created by deepak on 11/4/14.
 */
public class Main {

    private static String line = "1,2,3,4,5,6,7,8,9,10";

    public static void main(String[] args) {

        Adaptor adaptor = new Adaptor();
        Long sum = adaptor.sum(line);
        System.out.println("sum = " + sum);
    }
}
