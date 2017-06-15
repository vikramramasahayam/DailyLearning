package com.vik.learning.streams;

import java.util.Arrays;

public class UseStreams {

    public static void main(final String[] args) {
        State pa = new State(Arrays.asList("Philly", "Pittsburg"));
        State tn = new State(Arrays.asList("Memphis", "Nashville"));
        State al = new State(Arrays.asList("Mobile", "Hundsville"));

        Arrays.asList(pa, tn, al);

        // states.stream().map(s -> i -> {
        // return s.get(i);
        // });

    }

}
