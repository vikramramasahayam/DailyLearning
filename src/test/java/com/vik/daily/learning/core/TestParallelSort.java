package com.vik.daily.learning.core;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.vik.daily.learning.arrays.Sort;

public class TestParallelSort {

    private final List<String> names = Arrays.asList(" one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen");

    @Test
    public void testNormalSort() {
        final long currentTime = System.nanoTime();
        System.out.println(Sort.normalSort(names));
        System.out.println(System.nanoTime() - currentTime);
    }

    @Test
    public void testParallelSort() {
        final long currentTime = System.nanoTime();
        System.out.println(Sort.parallelSort(names));
        System.out.println(System.nanoTime() - currentTime);
    }
}
