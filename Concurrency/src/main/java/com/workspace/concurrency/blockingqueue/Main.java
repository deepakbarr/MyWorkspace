package com.workspace.concurrency.blockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by deepak on 10/29/14.
 */


public class Main {

    public static void main(String[] args) {
        BlockingQueue<Long> queue = new ArrayBlockingQueue<Long>(10);

        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));

        t1.start();
        t2.start();

    }

}

class Producer implements Runnable{

    BlockingQueue queue;

    Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {

        Random rand=new Random();
        while (true) {
            try {
                queue.put((long)rand.nextInt(50));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    BlockingQueue queue;

    Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                Long val=(Long)queue.take();

                System.out.println("Val = "+val+"  and   size = "+queue.size());

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
