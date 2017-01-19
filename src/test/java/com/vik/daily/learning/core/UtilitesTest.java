package com.vik.daily.learning.core;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UtilitesTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

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

    @Test
    public void testMatcherIs() {
        Assert.assertThat(true, Matchers.is(true));
        Assert.assertThat(Arrays.asList(1, 2, 3), Matchers.contains(1, 2, 3));
    }

    @Test
    public void testFlag() {
        boolean flag = false;
        expected.expect(IllegalStateException.class);
        org.springframework.util.Assert.state(flag, "There was an IllegalState Exception");
    }

}
