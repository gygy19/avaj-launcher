package com.simulator.enums;

/**
 * Created by jguyet on 9/6/17.
 */
public enum WeatherEnum {

    RAIN("RAIN"),
    FOG("FOG"),
    SUN("SUN"),
    SNOW("SNOW");

    private String type;

    public String getType() {
        return (this.type);
    }

    WeatherEnum(String type) {
        this.type = type;
    }
}
