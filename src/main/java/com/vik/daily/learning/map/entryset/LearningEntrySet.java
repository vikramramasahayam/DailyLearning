package com.vik.daily.learning.map.entryset;

import java.util.HashMap;
import java.util.Map;

public class LearningEntrySet {

    public static void main(final String[] args) {
        final Map<String, String> map = new HashMap<>();
        map.put("NJ", "New Jersey");
        map.put("PA", "Pennsylvania");

        for (final Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry);
        }

    }

}
