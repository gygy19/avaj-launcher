package com.simulator.enums;

/**
 * Created by jguyet on 9/6/17.
 */
public enum AirCraftEnum {

	Baloon("Baloon"),
	JetPlane("JetPlane"),
	Helicopter("Helicopter");

    private String type;

    public String getType() {
        return (this.type);
    }

    AirCraftEnum(String type) {
        this.type = type;
    }
}
