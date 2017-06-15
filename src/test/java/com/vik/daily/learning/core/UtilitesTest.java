package com.vik.daily.learning.core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UtilitesTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void printfUsage() {
        System.out.printf("%-18s", UtilitesTest.class.getName());
        System.out.println("\t Hello");
    }

    @Test
    public void testNanoTimeDelay() throws InterruptedException {
        final long time = System.currentTimeMillis();
        for (final long nano = System.nanoTime(); nano == System.nanoTime(););
        Assert.assertEquals(0, System.currentTimeMillis() - time);
    }

    @Test
    public void testMatcherIs() {
        Assert.assertThat(true, Matchers.is(true));
        Assert.assertThat(Arrays.asList(1, 2, 3), Matchers.contains(1, 2, 3));
    }

    @Test
    public void testFlag() {
        boolean flag = false;
        expected.expect(IllegalStateException.class);
        org.springframework.util.Assert.state(flag, "There was an IllegalState Exception");
    }

    @Test
    @Ignore
    public void testRuntimeExec() throws IOException {
        Process process = Runtime.getRuntime().exec("java -version");
        String output = new Scanner(process.getInputStream(), "UTF-16").useDelimiter("\\A").next();
        System.out.println(output);
    }

    @Test
    public void testCount() {
        List<Double> scores = Arrays.asList(0.0, 1.0, 0.0);
        System.out.println(Collections.frequency(scores, 0.0));
    }

    @Test
    public void testNullWithEquals() {
        List<String> fields = Arrays.asList("", " ", "   ");

        fields.forEach((field) -> {
            System.out.println("".equals(field.trim()));
        });
    }

    @Test
    public void testNullWithIsEmpty() {
        List<String> fields = Arrays.asList("", " ", "   ");

        fields.forEach((field) -> {
            System.out.println(field.trim().isEmpty());
        });
    }

    @Test
    public void testCharSet() {
        System.out.println(Charset.forName(System.getProperty("file.encoding")).name());
    }

    @Test
    public void testRange() {
        IntStream.range(1, 5).forEach(i -> System.out.println(i));
    }

}
