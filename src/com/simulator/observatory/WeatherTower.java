package com.simulator.observatory;

import com.simulator.aircraft.coordinates.Coordinates;
import com.simulator.provider.WeatherProvider;

/**
 * Created by jguyet on 9/6/17.
 */
public class WeatherTower extends Tower {

	/**
	 * __Constructor
	 */
    public WeatherTower() {
    	super();
    }

    /**
     * Change Weather reload Provider and call conditionChanged to parentClass
     */
    public void changeWeather() {
    	
        new WeatherProvider();
        
        this.conditionChanged();
    }

    /**
     * Select a current Weather on WeatherProvider
     * @param coordinates
     * @return String
     */
   public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates));
   }
}
