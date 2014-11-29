package com.workspace.design.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by deepak on 11/21/14.
 */
public class Newspaper {
    private List<Subscriber> list;

    public Newspaper() {
        this.list = new LinkedList<Subscriber>();
    }

    public void registerSubscriber(Subscriber s) {
        list.add(s);
    }

    public void removeSubscriber(String name) {

        System.out.println("list.size() = " + list.size());

        for (Subscriber s : list) {
            if (s.getName().equals(name)) {
                list.remove(s);
                break;
            }
        }
        System.out.println("list.size() = " + list.size());
    }


    public void setNewsPaper(String np) {
        for (Subscriber s : list)
            s.setNewsPaper(np);
    }
}
