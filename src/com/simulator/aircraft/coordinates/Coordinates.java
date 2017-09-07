package com.simulator.aircraft.coordinates;

/**
 * Created by jguyet on 9/6/17.
 */
public class Coordinates {

    private int longitude       = 0;
    private int latitude        = 0;
    private int height          = 0;

    /**
     * __Constructor<br>
     * if values is negative set to positive value
     * @param longitude
     * @param latitude
     * @param height
     */
    public Coordinates(int longitude, int latitude, int height) {

        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        
        if (this.height > 100)
        	this.height = 100;
        if (this.height < 0)
        	this.height = 0;
        if (this.latitude < 0)
        	this.latitude = 0;
        if (this.longitude < 0)
        	this.longitude = 0;
    }

    /**
     * get Longitude position
     * @return Integer
     */
    public int getLongitude() {
        return (this.longitude);
    }

    /**
     * get Latitude position
     * @return Integer
     */
    public int getLatitude() {
        return (this.latitude);
    }

    /**
     * get Height position
     * @return Integer
     */
    public int getHeight() {
        return (this.height);
    }
}
