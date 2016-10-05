package com.vik.daily.learning.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCheckParameterNotNull {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void checkParamterNotNull() {
        final CheckParameterNotNull test = new CheckParameterNotNull(null);
    }

    @Test
    public void checkParamterNotNullUsingThrown() throws Throwable {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Name Cann't be Null");
        final CheckParameterNotNull test = new CheckParameterNotNull(null);
    }

}
