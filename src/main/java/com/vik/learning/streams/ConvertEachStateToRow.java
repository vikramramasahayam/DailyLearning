package com.vik.learning.streams;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertEachStateToRow {

    public static void main(final String[] args) {
        State pa = new State(Arrays.asList("Philly", "Pittsburg"));
        State tn = new State(Arrays.asList("Memphis", "Nashville"));
        State al = new State(Arrays.asList("Mobile", "Hundsville"));

        List<State> states = Arrays.asList(pa, tn, al);

        final Convert<State, Row> convert = state -> (final int i) -> {
            return state.get(i);
        };

        // get data for each column.
        // IntStream.range(0, states.size() - 1).forEach(i -> {
        // states.stream().map(convert).forEach(row -> {
        // System.out.print(row.get(i) + " ,");
        // });
        // System.out.println();
        // });

        Stream<Row> rows = states.stream().map(convert);

        // rows.forEach(row -> {
        // System.out.println(row.get(0));
        // });

        rows.map(row -> {
            return IntStream.range(0, 2).mapToObj(i -> {
                String value = row.get(i).toString();
                System.out.println("Value is : " + value);
                return value;
            }).toArray(String[]::new);
        });

        // data_rows.map(row -> {
        // System.out.println(Arrays.toString(row));
        // return row;
        // });

        // Stream<Stream<Row>> streamedRows = IntStream.range(0, states.size() - 1).mapToObj(i -> {
        // Stream<Row> rows = states.stream().map(state -> convert.apply(state));
        // return rows;
        // });
        //
        // streamedRows.forEach(stream -> {
        // IntStream.range(0, 1).map(i -> {
        //
        // });
        // });
    }

    @FunctionalInterface
    public interface Row extends Serializable {
        public Object get(int i);
    }

    @FunctionalInterface
    public interface Convert<T, R> extends Function<T, R>, Serializable {}

}
