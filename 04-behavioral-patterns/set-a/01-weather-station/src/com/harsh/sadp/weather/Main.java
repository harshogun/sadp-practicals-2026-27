
package com.harsh.sadp.weather;

public class Main {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display =
                new CurrentConditionsDisplay();

        weatherData.addObserver(display);

        weatherData.setMeasurement(30.5f, 65.0f, 1012.0f);
        weatherData.setMeasurement(28.0f, 70.0f, 1010.0f);
        weatherData.setMeasurement(26.5f, 75.0f, 1008.0f);
    }
}
