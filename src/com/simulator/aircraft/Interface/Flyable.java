package com.simulator.aircraft.Interface;

import com.simulator.observatory.WeatherTower;

/**
 * Created by jguyet on 9/6/17.
 */
public interface Flyable {

	/**
	 * Update position of flyable aircraft by weather 
	 */
    public abstract void updateConditions();

    /**
     * register flayable aircraft on tower
     * @param weatherTower
     */
    public abstract void registerTower(WeatherTower weatherTower);
}
