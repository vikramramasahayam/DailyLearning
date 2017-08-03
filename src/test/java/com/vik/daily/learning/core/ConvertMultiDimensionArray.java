package com.vik.daily.learning.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ConvertMultiDimensionArray {

    @Test
    public void convertMultiDimensionArrayToListArray() {
        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 }
        };

        List<String[]> list = new ArrayList<>();
        for (int[] nums : matrix) {
            String[] array = Arrays.stream(nums).mapToObj(Integer::toString).toArray(String[]::new);
            list.add(array);
        }

        Assert.assertEquals(2, list.size());
        list.forEach(row -> {
            Assert.assertEquals(4, row.length);
        });
    }

}
