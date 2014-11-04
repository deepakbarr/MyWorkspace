package com.workspace.design.mvc;

/**
 * Created by deepak on 10/31/14.
 */
public class Model {

    long acc;
    String name;
    long balance;

    public Model(long acc, String name, long balance) {
        this.acc = acc;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Model{" +
                "acc=" + acc +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }


    public void setAcc(long acc) {
        this.acc = acc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAcc() {
        return acc;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
