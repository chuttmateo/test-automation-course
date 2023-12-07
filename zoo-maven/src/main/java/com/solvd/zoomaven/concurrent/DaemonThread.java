package com.solvd.zoomaven.concurrent;

public class DaemonThread extends Thread {


    {
        super.setDaemon(true);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonThread d = new DaemonThread();
        d.start();
        Thread.sleep(10);
        //Jvm will look for userThreads and if any of those threads are user Threads JVM will finish the process
    }
}