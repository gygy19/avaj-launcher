package com.simulator.aircraft.flyable;

import com.simulator.aircraft.AirCraft;
import com.simulator.aircraft.Interface.Flyable;
import com.simulator.aircraft.coordinates.Coordinates;
import com.simulator.enums.AirCraftEnum;
import com.simulator.observatory.WeatherTower;

/**
 * Created by jguyet on 9/6/17.
 */
public class Baloon extends AirCraft implements Flyable {

    private WeatherTower weatherTower;

    /**
     * __Constructor
     * @param name
     * @param coordinates
     */
    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
    	/*
    	 *	◦ SUN - Longitude increases with 2, Height increases with 4
		 *	◦ RAIN - Height decreases with 5
		 *	◦ FOG - Height decreases with 3
		 *	◦ SNOW - Height decreases with 15
    	 */
    	int longitude = 0;
    	int latitude = 0;
    	int height = 0;
    	String message = "";
    	
    	switch (this.weatherTower.getWeather(this.coordinates)) {
    		case "SUN":
    			longitude = 2;
    			height = 4;
    			message = "With the aid I reach the stratosphere !";
    		break ;
    		case "RAIN":
    			height = -5;
    			message = "A cool shower!";
    		break ;
    		case "FOG":
    			height = -3;
    			message = "Tower ? I see nothing.";
    		break ;
    		case "SNOW":
    			height = -15;
    			message = "Winter is comming.";
    		break ;
    	}
    	System.out.println(this.toString() + ": " + message);
    	this.coordinates = new Coordinates(this.coordinates.getLongitude() + longitude, this.coordinates.getLatitude() + latitude, this.coordinates.getHeight() + height);
    	
    	if (this.coordinates.getHeight() == 0) {
    		this.weatherTower.unregister(this);
    	}
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
    
    public String toString() {
    	return (AirCraftEnum.Baloon.getType() + "#" + this.name + "(" + this.id + ")");
    }
}
