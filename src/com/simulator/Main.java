package com.simulator;

import java.io.File;
import java.util.ArrayList;

import com.simulator.aircraft.AirCraftFactory;
import com.simulator.aircraft.Interface.Flyable;
import com.simulator.observatory.WeatherTower;
import com.simulator.utils.Utils;

/**
 * Created by jguyet on 9/6/17.
 */
public class Main {
	
	/**
	 * Statics Values
	 */
	public static ArrayList<String>		content;
	public static ArrayList<Flyable>	flyables = new ArrayList<Flyable>();
	public static int					boucle = 0;
	
    public static void main(String ... args) {

        if (args.length != 1) {
            System.out.println("Add name of simulation file on first argument.");
        	return ;
        }
        /*
         * File Checks :
         */
        File file = new File(args[0]);

        if (file.exists() == false) {
        	System.out.println("Couldn't not find file '" + file.getName() + "'.");
            return ;
        }
        if (file.canRead() == false) {
        	System.out.println("file '" + file.getName() + "' d'ont have right for read.");
        }
        Main.content = Utils.readOnArrayContent(file);
        if (Main.content.size() == 0) {
        	System.out.println("Counter doesn't exist.");
        	return ;
        }
        if (Main.checkHeaderFactory() ==  false || Main.boucle < 0) {
        	System.out.println("Invalid simulation count.");
        	return ;
        }
        
        /*
         *  Preload AirCrafts machines
         */
        for (String line : Main.content) {
        	String[] split = line.split(" ");
        	try
        	{
	        	//TYPE NAME LONGITUDE LATITUDE HEIGHT.
	        	Flyable flyer = (Flyable) AirCraftFactory.newAirCraft(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
	        	
	        	if (flyer == null) {
	        		System.out.println("The airCraft '" + split[0] + "' doens't exist");
	        		return ;
	        	}
	        	flyables.add(flyer);
        	} catch (NumberFormatException e) {
        		System.out.println("Error on number in format of new airCraft");
        		return ;
        	} catch (ArrayIndexOutOfBoundsException e) {
        		System.out.println("Error format of new airCraft");
        		return ;
        	}
        }
        
        /*
         * Build simulation
         */
        WeatherTower weaterTower = new WeatherTower();
        
        for (Flyable f : flyables) {
        	f.registerTower(weaterTower);
        }
        
        for (int i = 0; i < Main.boucle; i++) {
        	weaterTower.changeWeather();
        }
        
    }
    
    public static boolean checkHeaderFactory() {
    	try {
    		boucle = Integer.parseInt(content.get(0));
    	} catch (NumberFormatException e) {
    		return false;
    	}
    	content.remove(0);
    	return true;
    }

}
