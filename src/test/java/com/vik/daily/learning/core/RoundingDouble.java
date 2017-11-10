package com.vik.daily.learning.core;

import org.apache.commons.math3.util.Precision;
import org.junit.Test;

public class RoundingDouble {

    @Test
    public void testRounding() {
        double weightedCount = 0.1234567891234;
        double maxWeightedCount = 0.12345697894321;

        double weightedCountRounded = Precision.round(weightedCount, 5);
        double maxWeightedCountRounded = Precision.round(maxWeightedCount, 5);

        System.out.println("WeightedCount : " + weightedCountRounded + " , MaxWeightedCount : " + maxWeightedCountRounded);

        System.out.println(weightedCountRounded - maxWeightedCountRounded);
        System.out.println((weightedCountRounded - maxWeightedCountRounded) >= 0.0000001);

        System.out.println((weightedCount - maxWeightedCount) >= 0.0000001);
    }

}
