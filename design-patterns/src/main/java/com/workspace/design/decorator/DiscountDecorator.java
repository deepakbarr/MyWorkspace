package com.workspace.design.decorator;

import org.w3c.dom.views.AbstractView;

/**
 * Created by deepak on 11/4/14.
 */
public class DiscountDecorator extends AbstractDecorator {

    int discount;

    public DiscountDecorator(Item item, int disc) {
        super(item);
        this.discount = disc;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with " + discount + "% discount";
    }

    @Override
    public long getPrice() {
        System.out.println("Discounted price");
        return new Double(item.getPrice() * (1 - discount*1.0 / 100)).longValue();
    }
}
