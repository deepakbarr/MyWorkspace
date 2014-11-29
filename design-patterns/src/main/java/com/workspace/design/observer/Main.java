package com.workspace.design.observer;

/**
 * Created by deepak on 11/21/14.
 */
public class Main {
    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();
        newspaper.registerSubscriber(new Subscriber("deepak"));
        newspaper.registerSubscriber(new Subscriber("rajitha"));
        newspaper.setNewsPaper("NP 1");
        newspaper.setNewsPaper("NP 2");
        newspaper.registerSubscriber(new Subscriber("sunil"));
        newspaper.setNewsPaper("NP 3");
        newspaper.removeSubscriber("rajitha");
        newspaper.setNewsPaper("NP 4");
    }
}
