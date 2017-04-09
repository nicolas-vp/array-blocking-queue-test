package com.company;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    protected BlockingQueue<LocalTime> queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                if (! queue.isEmpty()) {
                    LocalTime sameElement = null;
                        for (LocalTime lt: queue) {
                            if (sameElement != null) {
                                if (sameElement.isAfter(lt)) {
                                    System.out.println("After!!!");
                                }
                            }
                            sameElement = lt;
                        }
                    System.out.println(queue.take().toString() + " " + queue.size());
                } else {
                    Thread.sleep(500);
                }
            }
       } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
