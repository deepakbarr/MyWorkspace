package com.workspace.demo.wildcards;

/**
 * Created by deepak.barr on 18/2/15.
 */
public class Automobile<T extends  Vehicle> {

    T t;
    public Automobile(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "t=" + t.toString() +
                '}';
    }
}
