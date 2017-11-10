package com.vik.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicate {

    public static void main(final String[] args) {

        // TODO this is incomplete

        // IntStream.of(1, 1, 1, 2, 3, 3, 4)
        // .parallel()
        // .collect(MapAndIndex::new, MapAndIndex::add, MapAndIndex::merge);
    }

    class MapAndIndex {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index;

        void add(final int value) {
            map.computeIfAbsent(value, x -> new ArrayList<>()).add(index++);
        }

        void merge(final MapAndIndex other) {
            other.map.forEach((value, list) -> {
                List<Integer> l = map.computeIfAbsent(value, x -> new ArrayList<>());
                for (int i : list)
                    l.add(i + index);
            });
            index += other.index;
        }

    }

}
