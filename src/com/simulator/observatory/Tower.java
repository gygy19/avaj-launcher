package com.simulator.observatory;

import java.util.ArrayList;
import java.util.Observable;

import com.simulator.aircraft.Interface.Flyable;

/**
 * Created by jguyet on 9/6/17.
 */
public abstract class Tower extends Observable {

    protected ArrayList<Flyable> observers =  new ArrayList<Flyable>();

    /**
     * super __Constructor
     */
    public Tower() {

    }

    /**
     * add flyable aircraft on observers list and print informations
     * @param flyable
     */
    public void register(Flyable flyable) {
    	this.observers.add(flyable);
    	System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
    }

    /**
     * remove flyable aircraft on observers list and print informations
     * @param flyable
     */
    public void unregister(Flyable flyable) {
    	this.observers.remove(flyable);
    	System.out.println("Tower says: " + flyable.toString() + " unregistered from weather tower.");
    }
    
    /**
     * updateConditions of all observers
     */
    protected void conditionChanged() {
    	ArrayList<Flyable> observers = new ArrayList<Flyable>();
        
        observers.addAll(this.observers);
        
        for (Flyable f : observers) {
        	f.updateConditions();
        }
    }
}
