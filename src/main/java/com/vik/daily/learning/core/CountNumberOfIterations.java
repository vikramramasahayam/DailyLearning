package com.vik.daily.learning.core;

import java.util.concurrent.atomic.AtomicLong;

public class CountNumberOfIterations {

    private final AtomicLong count = new AtomicLong(0);

    public void run(final long v) {
        count.getAndIncrement();
    }

    public long getCount() {
        return count.get();
    }

}
