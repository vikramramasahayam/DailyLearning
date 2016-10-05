package com.vik.daily.learning.concurrent;

import java.util.concurrent.CountDownLatch;

public class ConcurrencyUsingCountDownLatch {

    private final CountDownLatch latch1 = new CountDownLatch(1);
    private final CountDownLatch latch2 = new CountDownLatch(1);
    private final CountDownLatch latch3 = new CountDownLatch(1);

    public Runnable getRunnableOne() {
        return () -> {
            latch1.countDown();
            System.out.print("Hello ");
        };
    }

    public Runnable getRunnableTwo() {
        return () -> {
            try {
                latch3.await();
                latch2.countDown();
                System.out.print(" !");
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public Runnable getRunnableThree() {
        return () -> {
            try {
                latch1.await();
                latch3.countDown();
                System.out.print("World");
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
