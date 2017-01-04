package com.vik.daily.learning.concurrent.cyclic.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private CyclicBarrier barrier1;

    public CyclicBarrierExample(final CyclicBarrier barrier) {
        barrier1 = barrier;
    }

    public Runnable getRunnable() {
        return () -> {

            try {
                System.out.println("Before the Barrier");
                barrier1.await();
                System.out.println("After the Barrier");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

}
