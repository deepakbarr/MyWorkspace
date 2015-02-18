package com.workspace.demo.wildcards;

/**
 * Created by deepak.barr on 18/2/15.
 */
public class Car extends Vehicle {

    public Car(String name, int price) {
        super(name, price);
    }

    public Car() {
        super("CAR", 2000);
    }
}
