package com.workspace.design.decorator;

/**
 * Created by deepak on 11/4/14.
 */
public abstract class AbstractDecorator implements Item {

    Item item;

    protected AbstractDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }

    @Override
    public long getPrice() {
        return item.getPrice();
    }
}
