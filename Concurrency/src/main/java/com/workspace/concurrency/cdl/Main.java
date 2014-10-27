package com.workspace.concurrency.cdl;

import java.util.concurrent.CountDownLatch;

/**
 * Created by deepak on 10/27/14.
 */
class Worker extends Thread {

    private CountDownLatch cdl;

    public Worker(CountDownLatch cdl, String name) {
        super(name);
        this.cdl = cdl;

    }

    @Override
    public void run() {

        System.out.println("Thread is waiting " + getName());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread is finished " + getName());
        cdl.countDown();

    }
}

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        for (int i = 1; i <=5; i++) {
            new Worker(cdl, "Thread-" + i).start();
        }

        try {

            cdl.await();

            System.out.println("All is done !");

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
