package com.vik.daily.learning.arrays;

import java.util.Arrays;
import java.util.List;

public class Sort {

    public static List<String> normalSort(final List<String> names) {
        String[] arr = new String[names.size()];
        arr = names.toArray(arr);
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }

    public static List<String> parallelSort(final List<String> names) {
        String[] arr = new String[names.size()];
        arr = names.toArray(arr);
        Arrays.parallelSort(arr);
        return Arrays.asList(arr);
    }
}
