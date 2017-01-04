package com.vik.daily.performance.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CollectionPerformance {

    private List<Integer> list;

    public void addToArrayList(final int iterations) {
        list = new ArrayList<>();
        IntStream.range(0, iterations).forEach(i -> {
            list.add(i);
        });
    }

    public void addToLinkedList(final int iterations) {
        list = new LinkedList<>();
        IntStream.range(0, iterations).forEach(i -> {
            list.add(i);
        });
    }

}
