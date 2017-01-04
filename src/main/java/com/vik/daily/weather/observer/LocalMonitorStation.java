package com.vik.daily.weather.observer;

import java.util.Observable;
import java.util.Observer;

public class LocalMonitorStation implements Observer {

    @Override
    public void update(final Observable observable, final Object arg) {
        System.out.println(((Weather) observable).getTemperature());
    }

}
