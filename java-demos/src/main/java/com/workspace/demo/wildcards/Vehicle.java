package com.workspace.demo.wildcards;

/**
 * Created by deepak.barr on 18/2/15.
 */
public abstract class Vehicle {

    private String name;
    private int price;

    public Vehicle(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
