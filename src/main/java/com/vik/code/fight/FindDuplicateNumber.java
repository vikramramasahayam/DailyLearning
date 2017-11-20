package com.vik.code.fight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicateNumber {

    // IntStream.of(1, 1, 1, 2, 3, 3, 4)
    // .parallel()
    // .collect(MapAndIndex::new, MapAndIndex::add, MapAndIndex::merge);

    public static Integer findFirstDuplicate(final Map<Integer, List<Integer>> valueIndices) {
        List<Integer> values = valueIndices.keySet().stream().filter(k -> {
            return valueIndices.get(k).size() > 1;
        }).collect(Collectors.toList());
        System.out.println("Values are : " + values);

        int duplicateFirstIndex = -1;
        for (Integer value : values) {
            List<Integer> indexes = valueIndices.get(value);
            int min = indexes.stream().min((a, b) -> {
                return a < b ? a : b;
            }).get();
            if (duplicateFirstIndex == -1) {
                duplicateFirstIndex = min;
            } else if (min < duplicateFirstIndex) {
                duplicateFirstIndex = min;
            }
        }
        return duplicateFirstIndex;
    }

    public static Map<Integer, List<Integer>> findDuplicates(final List<Integer> numbers) {
        final Map<Integer, List<Integer>> valueIndices = new HashMap<>();

        IntStream.range(0, numbers.size()).boxed().forEach(i -> {
            List<Integer> indicies = valueIndices.getOrDefault(numbers.get(i), new ArrayList<>());
            indicies.add(i);
            valueIndices.put(numbers.get(i), indicies);
        });

        System.out.println("Value Indices " + valueIndices);

        return valueIndices;
    }

}
