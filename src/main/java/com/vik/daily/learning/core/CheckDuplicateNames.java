package com.vik.daily.learning.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheckDuplicateNames {

    public static void main(final String[] args) {
        final List<String> names = Arrays.asList("Hello", "World", "Java", "Hello");

        names.stream().filter((name) -> Collections.frequency(names, name) > 1).collect(Collectors.toSet()).forEach(System.out::println);
    }

}
