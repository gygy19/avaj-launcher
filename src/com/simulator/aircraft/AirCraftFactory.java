package com.simulator.aircraft;

import com.simulator.aircraft.coordinates.Coordinates;
import com.simulator.aircraft.flyable.Baloon;
import com.simulator.aircraft.flyable.Helicopter;
import com.simulator.aircraft.flyable.JetPlane;

/**
 * Created by jguyet on 9/6/17.
 */
public final class AirCraftFactory {

	/**
	 * Factory selector airCraft class from String <b>type</b>
	 * @param type
	 * @param name
	 * @param longitude
	 * @param latitude
	 * @param height
	 * @return
	 */
    public static AirCraft newAirCraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates cord = new Coordinates(longitude, latitude, height);
        AirCraft newAirCraft = null;

        switch (type) {
            case "Baloon":
                newAirCraft = new Baloon(name, cord);
                break ;
            case "JetPlane":
                newAirCraft = new JetPlane(name, cord);
                break ;
            case "Helicopter":
                newAirCraft = new Helicopter(name, cord);
                break ;
        }
        return (newAirCraft);
    }
}
