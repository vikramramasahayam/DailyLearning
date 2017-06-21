package com.vik.learning.streams;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ConvertEachStateToRow {

    public static void main(final String[] args) {
        State pa = new State(Arrays.asList("Philly", "Pittsburg"));
        State tn = new State(Arrays.asList("Memphis", "Nashville"));
        State al = new State(Arrays.asList("Mobile", "Hundsville"));

        List<State> states = Arrays.asList(pa, tn, al);

        final Convert<State, Row> convert = state -> (final int i) -> {
            return state.get(i);
        };

        IntStream.range(0, states.size() - 1).forEach(i -> {
            states.stream().map(convert).forEach(row -> {
                System.out.print(row.get(i) + " ,");
            });
            System.out.println();
        });
    }

    @FunctionalInterface
    public interface Row extends Serializable {
        public Object get(int i);
    }

    @FunctionalInterface
    public interface Convert<T, R> extends Function<T, R>, Serializable {}

}
