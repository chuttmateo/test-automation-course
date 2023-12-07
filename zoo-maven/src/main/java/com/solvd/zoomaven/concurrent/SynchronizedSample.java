package com.solvd.zoomaven.concurrent;

public class SynchronizedSample {

    static class Counter{
        int count;
        //With synchronized we avoid the race condition
        public synchronized void increment(){
            count++;
        }
    }


    public static void main(String[] args) {

        Counter c = new Counter();
        Runnable r = ()->{
            for (int i = 0; i < 100_000; i++) {
                c.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(c.count);

    }
}
