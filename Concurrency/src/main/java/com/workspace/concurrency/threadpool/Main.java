package com.workspace.concurrency.threadpool;

import javax.rmi.CORBA.Tie;
import java.util.concurrent.*;

/**
 * Created by deepak on 10/27/14.
 */


class Worker implements Runnable {

    String name;

    Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + " Started");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " Finished");
    }
}



public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            executorService.submit(new Worker("Task " + i));
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(6, TimeUnit.SECONDS);
            System.out.println("Over!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
