package com.vik.daily.learning.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestTimeOut {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(timeout = 100)
    public void testTimeout() throws InterruptedException {
        System.out.println("Starting the test");
        Thread.currentThread().sleep(10000);
        System.out.println("Ending the test");
    }

    @Test
    public void testDumpStack() {
        Thread.dumpStack();
    }

}
