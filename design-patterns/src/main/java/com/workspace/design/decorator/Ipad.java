package com.workspace.design.decorator;

import java.util.Iterator;

/**
 * Created by deepak on 11/4/14.
 */
public class Ipad implements Item {

    String description;
    long price;

    public Ipad() {
        this.description = "Apple iPad";
        this.price = 40000;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public long getPrice() {
        return price;
    }
}
