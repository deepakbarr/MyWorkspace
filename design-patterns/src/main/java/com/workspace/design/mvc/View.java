package com.workspace.design.mvc;

/**
 * Created by deepak on 10/31/14.
 */
public class View implements Runnable{

    long acc;
    String name;
    long balance;

    public void setAcc(long acc) {
        this.acc = acc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }



    public void run() {

        while(true) {
            System.out.println(String.format("Acc = %s  Name = %s Balance = %s", acc, name, balance));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
