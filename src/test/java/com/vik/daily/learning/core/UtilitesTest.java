package com.vik.daily.learning.core;

import org.junit.Assert;
import org.junit.Test;

public class UtilitesTest {

    @Test
    public void printfUsage() {
        System.out.printf("%-18s", UtilitesTest.class.getName());
        System.out.println("\t Hello");
    }

    @Test
    public void testNanoTimeDelay() throws InterruptedException {
        final long time = System.currentTimeMillis();
        for (final long nano = System.nanoTime(); nano == System.nanoTime(););
        Assert.assertEquals(0, System.currentTimeMillis() - time);

    }
}
