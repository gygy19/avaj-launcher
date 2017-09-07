package com.simulator.aircraft.flyable;

import com.simulator.aircraft.AirCraft;
import com.simulator.aircraft.Interface.Flyable;
import com.simulator.aircraft.coordinates.Coordinates;
import com.simulator.enums.AirCraftEnum;
import com.simulator.observatory.WeatherTower;

/**
 * Created by jguyet on 9/6/17.
 */
public class Helicopter extends AirCraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
    	/*
    	 *	◦ SUN - Longitude increases with 10, Height increases with 2
		 *	◦ RAIN - Longitude increases with 5
		 *	◦ FOG - Longitude increases with 1
		 *	◦ SNOW - Height decreases with 12
    	 */
    	int longitude = 0;
    	int latitude = 0;
    	int height = 0;
    	String message = "";
    	
    	switch (this.weatherTower.getWeather(this.coordinates)) {
    		case "SUN":
    			longitude = 10;
    			height = 2;
    			message = "Is a temp to save from the dog !";
    		break ;
    		case "RAIN":
    			longitude = 5;
    			message = "Tower ? The blades are wet.";
    		break ;
    		case "FOG":
    			longitude = 1;
    			message = "I see nothing.";
    		break ;
    		case "SNOW":
    			height = -12;
    			message = "The frozen guided blades us !!";
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
    	return (AirCraftEnum.Helicopter.getType() + "#" + this.name + "(" + this.id + ")");
    }

}
