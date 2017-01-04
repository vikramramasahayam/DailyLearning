package com.vik.daily.learning.core;

import org.junit.Before;
import org.junit.Test;

import com.vik.daily.performance.collections.CollectionPerformance;

public class CollectionPerformanceTest {

    private CollectionPerformance underTest;

    @Before
    public void setup() {
        underTest = new CollectionPerformance();
    }

    @Test
    public void testAddToArrayList() {
        final long startTime = System.currentTimeMillis();
        underTest.addToArrayList(10000000);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testAddToLinkedList() {
        final long startTime = System.currentTimeMillis();
        underTest.addToLinkedList(10000000);
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
