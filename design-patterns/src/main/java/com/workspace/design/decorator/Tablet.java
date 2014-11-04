package com.workspace.design.decorator;

/**
 * Created by deepak on 11/4/14.
 */
public class Tablet implements Item {
    String description;
    long price;

    public Tablet() {
        this.description = "Samsung Tab";
        this.price = 20000;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }
}
