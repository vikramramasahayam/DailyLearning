package com.vik.daily.learning.core;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.vik.collection.Animal;
import com.vik.collection.Lion;
import com.vik.collection.Tiger;

public class CollectionsTest {

    @Test
    public void testAddCollection() {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        addCollection(Arrays.asList(tiger, lion));
    }

    public static <T extends Animal> void addCollection(final List<T> animals) {
        System.out.println(animals.size());
    }

}
