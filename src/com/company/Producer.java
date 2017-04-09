package com.company;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    protected BlockingQueue<LocalTime> queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                int b = 100;
                queue.put(LocalTime.now());
                Thread.sleep((int) (Math.random() * b));
                queue.put(LocalTime.now());
                Thread.sleep((int) (Math.random() * b/4));
                Double f=1.4;
                    for (int x=0; x<1000; x++){
                        f=f+Math.random();
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}