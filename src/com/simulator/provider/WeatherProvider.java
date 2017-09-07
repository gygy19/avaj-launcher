package com.simulator.provider;

import com.simulator.aircraft.coordinates.Coordinates;
import com.simulator.enums.WeatherEnum;
import com.simulator.utils.Utils;

/**
 * Created by jguyet on 9/6/17.
 */
public class WeatherProvider {

    /**
     * Singleton +weatherProvider
     */
    private static WeatherProvider weatherProvider;

    /**
     * Private Value -weather
     */
    private String weather;

    /**
     * __Constructor<br>
     * select random Weather time
     */
    public WeatherProvider() {
        WeatherProvider.weatherProvider = this;
        
        int max = WeatherEnum.values().length - 1;
    	
        this.weather = WeatherEnum.values()[Utils.getRandomValue(0, max)].getType();
    }

    /**
     * function Singleton
     * @return WeatherProvider
     */
    public static WeatherProvider getWeatherProvider() {
        return (WeatherProvider.weatherProvider);
    }

    /**
     * get current Weather value
     * @param coordinates
     * @return String
     */
    public String getCurrentWeather(Coordinates coordinates) {
    	return (this.weather);
    }
}
