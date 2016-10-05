package com.vik.daily.learning.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

import com.vik.daily.learning.concurrent.ConcurrencyUsingCountDownLatch;

public class TestConcurrencyUsingCountDownLatch {

    private ConcurrencyUsingCountDownLatch underTest;

    @Before
    public void initalize() {
        underTest = new ConcurrencyUsingCountDownLatch();
    }

    @Test
    public void test() {

        final ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(underTest.getRunnableOne());
        service.submit(underTest.getRunnableTwo());
        service.submit(underTest.getRunnableThree());
        service.shutdown();
    }

}
