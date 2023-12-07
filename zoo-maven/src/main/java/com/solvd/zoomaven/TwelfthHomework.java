package com.solvd.zoomaven;

import com.solvd.zoomaven.concurrent.*;


public class TwelfthHomework {
    /*
    1-Create 2 Threads using Runnable and Thread.
    2-Create Connection Pool.Use collection from java.util.concurrent package.
      Connection class may be mocked.The pool should be thread safe and lazy initialized.

    3-Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads). 5 threads should be able to get the connection.
      2 Threads should wait for the next available connection. The program should wait as well.

    4-Implement 4th part but with IFuture and CompletableStage.*/

    public static void main(String[] args) {
        try {
            //createThread();
            usingConnectionPool();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static void createThread() throws InterruptedException {
        System.out.println("Create 2 Threads using Runnable and Thread.");
        MyThread thread1 = new MyThread();

        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);

        thread1.start();
        //thread1.join();
        thread2.start();
        System.out.println(" ");
    }

    public static void usingConnectionPool() throws InterruptedException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool(5);
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                connectionPool.releaseConnection(new Connection());
            }).start();
        }

        Thread.sleep(5000);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                connectionPool.getConnection();
            }).start();
        }

    }

}
