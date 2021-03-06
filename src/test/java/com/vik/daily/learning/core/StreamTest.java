package com.vik.daily.learning.core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StreamTest {

    private static AtomicInteger count = new AtomicInteger(0);

    @Before
    public void resetCount() {
        count = new AtomicInteger(0);
    }

    @Test
    public void arrayToStreamScenario1() {
        // Stream has three parts initializer, intermediate operation ( examples : filter() , skip() , termination ( examples : collect(), reduce() )

        // there is no termination so log method will not be called.
        Stream<String> values = Stream.of("1", "2", "3");
        values.filter(value -> {
            log();
            return value.equals("1");
        }).map(Integer::parseInt);

        Assert.assertEquals(0, count.get());
    }

    @Test
    public void arrayToStreamScenario2() {
        Stream<String> values = Stream.of("1", "2", "3");
        values.filter(value -> {
            log();
            return value.equals("1");
        }).map(Integer::parseInt).count();
        Assert.assertEquals(3, count.get());
    }

    @Test
    public void arrayToStreamScenario3() {
        Stream<String> values = Stream.of("1", "2", "3");
        values.skip(2).filter(value -> {
            log();
            return value.equals("1");
        }).map(Integer::parseInt).count();
        Assert.assertEquals(1, count.get());
    }

    private static void log() {
        System.out.println("inside log " + count.incrementAndGet());
    }

    @Test
    public void StringBuilderTest() {
        List<String> values = Arrays.asList("one", "two", "three");
        Builder<String> builder = Stream.builder();
        values.forEach(value -> {
            builder.add(value);
        });

        Stream<String> stream = builder.build();

        List<String> returnedValues = stream.collect(Collectors.toList());
        Assert.assertEquals(values, returnedValues);
    }

    @Test
    public void findMinListValue() {
        Stream<Integer> numbers = Stream.of(1, -1, 0, 2);
        Integer min = numbers.min((o1, o2) -> Integer.compare(o1, o2)).get();
        System.out.println("Min : " + min);
    }

}
