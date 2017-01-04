package com.vik.daily.learning.core;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

import com.vik.daily.learning.concurrent.cyclic.barrier.CyclicBarrierExample;

public class TestCyclicBarrierExample {

    private CyclicBarrierExample example;
    private ExecutorService service;

    @Before
    public void setup() {
        example = new CyclicBarrierExample(new CyclicBarrier(2));
        service = Executors.newFixedThreadPool(5);
    }

    @Test
    public void testBarrier() throws Exception {
        service.submit(example.getRunnable());
        service.submit(example.getRunnable());
        Thread.sleep(10);
        service.shutdown();
    }

}
