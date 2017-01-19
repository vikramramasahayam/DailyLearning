package com.vik.daily.learning.core;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.util.ClassUtils;

public class SpringUtilitesTest {

    private static final String CLASSNAME = SpringUtilitesTest.class.getName();
    @Rule
    public ExpectedException exp = ExpectedException.none();

    @Test
    public void testFindResourceFile() {
        final String filePath = String.format("classpath:%s-context.xml", ClassUtils.convertClassNameToResourcePath(CLASSNAME));
        Assert.assertEquals("classpath:com/vik/daily/learning/core/SpringUtilitesTest-context.xml", filePath);
    }

    @Test
    public void testSpringAssertion() {
        exp.expect(IllegalStateException.class);
        exp.expectMessage("There is an Illegal State Expression");
        boolean flag = false;
        org.springframework.util.Assert.state(flag, "There is an Illegal State Expression");
    }

}
