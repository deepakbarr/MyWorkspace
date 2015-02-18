package com.workspace.demo.wildcards;

/**
 * Created by deepak.barr on 18/2/15.
 */
public abstract class Electronics {

    private String name;
    private int price;

    public Electronics(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
