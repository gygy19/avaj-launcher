package com.simulator.aircraft;

import com.simulator.aircraft.coordinates.Coordinates;

/**
 * Created by jguyet on 9/6/17.
 */
public abstract class AirCraft {

    private static long idCounter = 0;

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    /**
     * __Constructor
     * @param name
     * @param coordinates
     */
    public AirCraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = AirCraft.getNextId();
    }

    /**
     * Static function for get nextId (new)
     * @return long
     */
    private static long getNextId() {
        return ((AirCraft.idCounter = AirCraft.idCounter + 1));
    }
    
}
