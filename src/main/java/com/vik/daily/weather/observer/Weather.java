package com.vik.daily.weather.observer;

import java.util.Observable;

public class Weather extends Observable {

    private double temperature;

    public Weather(final double temp) {
        this.temperature = temp;
    }

    public void setTemperature(final double temp) {
        this.temperature = temp;
        setChanged();
        notifyObservers();
    }

    public double getTemperature() {
        return this.temperature;
    }

}
