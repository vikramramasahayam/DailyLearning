package com.vik.learning.streams;

import java.io.Serializable;
import java.util.function.Function;
import java.util.stream.IntStream;

public class UseSerializableFunctions {

    public static void main(final String[] args) {
        String[] cityNames = { "Philly", "Pittsburg" };

        final SampleFunction<Object[], Test> getCity = cities -> (final int i) -> cities[i];

        final SampleFunction<Test, Object[]> getCities = (final Test test) -> IntStream.range(0, cityNames.length).mapToObj(i -> {
            return ((String) test.getTest(i)).substring(0, 2);
        }).toArray();

        System.out.println(getCity);
        System.out.println(getCities);

        Test test = getCity.apply(cityNames);
        System.out.println("Test is ::: " + test.getTest(0));

        final SampleFunction<Test, Test> citiesToShort = c -> getCity.apply(getCities.apply(c));

        Test shortTest = citiesToShort.apply(test);
        System.out.println("Short Test is :: " + shortTest.getTest(1));

    }

    @FunctionalInterface
    private interface SampleFunction<T, R> extends Function<T, R>, Serializable {}

    @FunctionalInterface
    private static interface Test extends Serializable {
        public Object getTest(int i);
    }

}
