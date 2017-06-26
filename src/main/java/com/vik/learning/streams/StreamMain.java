package com.vik.learning.streams;

import java.util.Arrays;
import java.util.List;

public class StreamMain {

    public static void main(final String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        // 1*1 + 1*2 + 1*3 + 1*4 =10
        Integer parallel_total = numbers.parallelStream().reduce(1, (n1, n2) -> n1 * n2, (x, y) -> x + y);
        System.out.println("Parallel Total is : " + parallel_total);

        // (((1*1)*2)*3)*4 = 24 // combiner last parameter doesn't come into play.
        Integer total = numbers.stream().reduce(1, (n1, n2) -> n1 * n2, (x, y) -> x + y);
        System.out.println("Total is : " + total);
    }

}
