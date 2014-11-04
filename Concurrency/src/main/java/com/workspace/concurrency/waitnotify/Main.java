package com.workspace.concurrency.waitnotify;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by deepak on 10/29/14.
 */

class Processor {

    private final int LIMIT = 10;
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(LIMIT);

    public void produce() throws InterruptedException {
        Random rand = new Random();

        System.out.println(queue.size());
        while (true) {
            synchronized (this) {
                System.out.println("queue size " +queue.size());
                while (queue.size() != LIMIT) {
                    int k = rand.nextInt(40);
                    queue.put(k);
                    System.out.println("Inserted = " + k + "   Size =" + queue.size());
                    Thread.sleep(500);
                }
                wait();
            }
        }

    }

    public void consume() throws InterruptedException {

        Thread.sleep(2000);

            while(true) {
                synchronized (this) {
                    if(queue.size()==LIMIT) {
                    Thread.sleep(200);
                    while (queue.size() != 0) {
                        int k = queue.take();
                        System.out.println("Taken = " + k + "   Size =" + queue.size());
                        Thread.sleep(500);
                    }
                    notify();
                }
            }
        }
    }

}


public class Main {

    public static void main(String[] args) {

        System.out.println("Hey");
        final Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }


}
