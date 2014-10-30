package com.workspace.concurrency.waitnotify;

/**
 * Created by deepak on 10/29/14.
 */

class Processor {

    public void produce()
    {


    }

    public void consume()
    {


    }

}


public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable(processor) {
            @Override
            public void run() {
                processor.produce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.consume();
            }
        });

    }


}
