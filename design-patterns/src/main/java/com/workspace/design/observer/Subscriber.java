package com.workspace.design.observer;

/**
 * Created by deepak on 11/21/14.
 */
public class Subscriber {
    String name;
    String newsPaper;

    public Subscriber(String name) {
        this.name = name;
    }

    public Subscriber() {
    }

    public void setNewsPaper(String newsPaper) {
        this.newsPaper = newsPaper;
        System.out.println(name+ " got news paper "+this.newsPaper);
    }

    public String getName() {
        return name;
    }
}
