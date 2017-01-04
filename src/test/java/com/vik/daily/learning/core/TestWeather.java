package com.vik.daily.learning.core;

import org.junit.Test;

import com.vik.daily.weather.observer.LocalMonitorStation;
import com.vik.daily.weather.observer.Weather;

public class TestWeather {

    @Test
    public void testTempearture() throws Exception {
        final Weather weather = new Weather(10);
        final LocalMonitorStation station1 = new LocalMonitorStation();
        weather.addObserver(station1);
        weather.setTemperature(20);
    }

}
