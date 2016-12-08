package com.vik.daily.learning.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumToStringList {

    public enum AllNames {
        JOE,
        JACK,
        JILL
    }

    public static void main(final String[] args) {

        final Stream<AllNames> names = Arrays.asList(AllNames.values()).stream();
        final List<String> list_names = names.map(AllNames::name).collect(Collectors.toList());
        System.out.println(list_names);

    }

}
