package com.vik;

import org.springframework.core.env.Environment;

public class Configuration {

    // @Autowired
    Environment environment;

    public String getName() {
        return environment.getProperty("personName");
    }
}
