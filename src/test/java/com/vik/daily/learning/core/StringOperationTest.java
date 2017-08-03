package com.vik.daily.learning.core;

import java.util.StringJoiner;

import org.junit.Test;

public class StringOperationTest {

    @Test
    public void testStringFormat() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        joiner.add("one").add("two");
        System.out.println(joiner.toString());

    }
}
