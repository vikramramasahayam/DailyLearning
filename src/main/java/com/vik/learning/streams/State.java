package com.vik.learning.streams;

import java.util.Iterator;
import java.util.List;

public class State implements Iterable<String> {

    private List<String> cities;

    public State(final List<String> cities) {
        this.cities = cities;
    }

    @Override
    public Iterator<String> iterator() {
        return cities.iterator();
    }

    public String get(final Integer i) {
        return cities.get(i);
    }

}
