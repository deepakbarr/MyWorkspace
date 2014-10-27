package com.workspace.demo.clone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by deepak on 10/27/14.
 */


class Emp implements Cloneable {

    String name;

    Emp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

public class Main {

    public static void main(String[] args) {

        Emp obj1 = new Emp("Deepak");

        Emp obj2 = (Emp)obj1.clone();

        System.out.println(obj1.getName());
        System.out.println(obj2.getName());


    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize is called");
        super.finalize();
    }
}
