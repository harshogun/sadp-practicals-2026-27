
package com.harsh.sadp.weather;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setMeasurement(
            float temperature,
            float humidity,
            float pressure) {

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers(this);
    }
}
