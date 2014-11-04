package com.workspace.design.decorator;

/**
 * Created by deepak on 11/4/14.
 */
public class Main {

    public static void main(String[] a) {

        Item tab = new Tablet();
        Item discountedTab = new DiscountDecorator(tab, 10);

        System.out.println("tab.getDescription() = " + tab.getDescription());
        System.out.println("tab.getPrice() = " + tab.getPrice());
        System.out.println("discountedTab.getDescription() = " + discountedTab.getDescription());
        System.out.println("discountedTab.getPrice() = " + discountedTab.getPrice());

        Item ipad = new Ipad();
        Item discountediPad = new DiscountDecorator(ipad, 10);

        System.out.println("ipad.getDescription() = " + ipad.getDescription());
        System.out.println("ipad.getPrice() = " + ipad.getPrice());
        System.out.println("discountediPad.getDescription() = " + discountediPad.getDescription());
        System.out.println("discountediPad.getPrice() = " + discountediPad.getPrice());
    }
}
