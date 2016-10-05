package com.vik.daily.learning.core;
import org.springframework.util.Assert;

public class CheckParameterNotNull {

    public CheckParameterNotNull(final String name) {
        Assert.notNull(name, "Name Cann't be Null");
    }

}
