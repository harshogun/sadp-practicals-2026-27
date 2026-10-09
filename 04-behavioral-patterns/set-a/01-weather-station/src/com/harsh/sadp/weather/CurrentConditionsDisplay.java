
package com.harsh.sadp.weather;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class CurrentConditionsDisplay implements Observer {

    @Override
    public void update(Observable observable, Object data) {

        if (data instanceof WeatherData weather) {
            System.out.println("Weather Update:");
            System.out.println(
                    "Temperature: "
                            + weather.getTemperature() + " °C"
            );
            System.out.println(
                    "Humidity: "
                            + weather.getHumidity() + "%"
            );
            System.out.println(
                    "Pressure: "
                            + weather.getPressure() + " hPa"
            );
            System.out.println("--------------------");
        }
    }
}
