package com.simulator.aircraft.flyable;

import com.simulator.aircraft.AirCraft;
import com.simulator.aircraft.Interface.Flyable;
import com.simulator.aircraft.coordinates.Coordinates;
import com.simulator.enums.AirCraftEnum;
import com.simulator.observatory.WeatherTower;

/**
 * Created by jguyet on 9/6/17.
 */
public class JetPlane extends AirCraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
    	/*
    	 *	◦ SUN - Latitude increases with 10, Height increases with 2
		 *	◦ RAIN - Latitude increases with 5
		 *	◦ FOG - Latitude increases with 1
		 *	◦ SNOW - Height decreases with 7
    	 */
    	int longitude = 0;
    	int latitude = 0;
    	int height = 0;
    	String message = "";
    	
    	switch (this.weatherTower.getWeather(this.coordinates)) {
    		case "SUN":
    			longitude = 10;
    			height = 2;
    			message = "Oh what a sun !";
    		break ;
    		case "RAIN":
    			longitude = 5;
    			message = "It's obvious.";
    		break ;
    		case "FOG":
    			longitude = 1;
    			message = "The tower, what a shit time.";
    		break ;
    		case "SNOW":
    			height = -7;
    			message = "The tower, where is the airstrip ?";
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
    	return (AirCraftEnum.JetPlane.getType() + "#" + this.name + "(" + this.id + ")");
    }

}
