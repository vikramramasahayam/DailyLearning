package com.vik.learning.streams;

import java.util.List;

public class State {
    // implements Iterable<String> {

    public String[] cities;

    public State(final List<String> cities) {
        this.cities = cities.toArray(new String[cities.size()]);
    }

    // @Override
    // public Iterator<String> iterator() {
    // return cities.iterator();
    // }

    public String get(final Integer i) {
        return cities[i];
    }

}
