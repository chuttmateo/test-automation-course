package com.solvd.zoomaven.concurrent;

public class VolatileSample {

    public static volatile boolean stop = false;
    private static boolean valueOfStopInReader;

    public static void main(String[] args) throws InterruptedException {
        Thread reader = new Thread(() ->
        {
            while (!stop) {
                valueOfStopInReader = stop;
            }
            System.out.println("Reader Thread finished " + stop);
        });


        Thread writer = new Thread(() ->
        {
            var rounds = 0;
            while (!stop) {
                rounds++;
                stop = rounds == 1_000_000;
            }
            System.out.println("Writer Thread finished " + stop);
        });
        reader.start();
        writer.start();

        Thread.sleep(1000);
        System.out.println("Value of stop in Reader: " + valueOfStopInReader);

    }

}
