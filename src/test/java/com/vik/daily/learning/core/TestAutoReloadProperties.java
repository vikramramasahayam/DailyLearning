package com.vik.daily.learning.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vik.daily.auto.reload.properties.AutoLoadProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/app-context.xml")
public class TestAutoReloadProperties {

    @Autowired
    private AutoLoadProperty applicationProperties;

    @Test
    public void testAppProperties() throws Exception {

        final long currentTime = System.currentTimeMillis();

        while (true) {
            System.out.println(applicationProperties.getProperty("mode"));
            final long duration = System.currentTimeMillis() - currentTime;
            Thread.sleep(1000);
            if (duration > 1000000) {
                break;
            }
        }

    }

}
