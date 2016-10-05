package com.vik.daily.learning.core;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCountNumberOfIterations {

    private CountNumberOfIterations iterations;

    @Before
    public void initialize() {
        iterations = new CountNumberOfIterations();
    }

    @Test
    public void testRun() {
        IntStream.rangeClosed(1, 3).forEach(iterations::run);
        Assert.assertEquals(iterations.getCount(), 3);
    }

}
