package com.vik.daily.auto.reload.properties;

import javax.annotation.PostConstruct;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.stereotype.Component;

@Component
public class AutoLoadProperty {

    private PropertiesConfiguration configuration;
    private static final String FILEPATH = System.getProperty("user.home") + "/workspace/PetProjects/DailyLearning/src/main/resources/app.properties";

    @PostConstruct
    private void init() {
        try {

            configuration = new PropertiesConfiguration(FILEPATH);
            final FileChangedReloadingStrategy fileChangeReloadStrategy = new FileChangedReloadingStrategy();
            fileChangeReloadStrategy.setRefreshDelay(1000);
            configuration.setReloadingStrategy(fileChangeReloadStrategy);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(final String key) {
        return (String) configuration.getProperty(key);
    }

}
