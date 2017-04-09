package com.company;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<LocalTime> queue = new ArrayBlockingQueue(1024);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
