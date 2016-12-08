package com.vik.daily.learning.core;

import org.junit.Assert;
import org.junit.Test;

public class TestNanoTimeWait {

    @Test
    public void testNanoTimeDelay() throws InterruptedException {
        final long time = System.currentTimeMillis();
        for (final long nano = System.nanoTime(); nano == System.nanoTime(););
        Assert.assertEquals(0, System.currentTimeMillis() - time);

    }

}
