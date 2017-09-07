package com.simulator.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jguyet on 9/6/17.
 */
public class Utils {

	public static String readContent(File file) {

        FileReader fileR = null;
        BufferedReader reader = null;
        String content = "";

        try {
            fileR = new FileReader(file.getName());

            reader = new BufferedReader(fileR);

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
            	if (currentLine.equalsIgnoreCase(""))
            		continue ;
            	content += currentLine + "\n";
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fileR != null)
                    fileR.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (content);
    }
	
	public static ArrayList<String> readOnArrayContent(File file) {

        FileReader fileR = null;
        BufferedReader reader = null;
        ArrayList<String> content = new ArrayList<String>();

        try {
            fileR = new FileReader(file.getName());

            reader = new BufferedReader(fileR);

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
            	if (currentLine.equalsIgnoreCase(""))
            		continue ;
            	content.add(currentLine);
            }
        } catch (IOException e) {

        } finally {
            try {
                if (fileR != null)
                    fileR.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (content);
    }
	
	public static int getRandomValue(int min, int max) {
	    int randomNum = (int) (Math.random() * ((max - min) + 1));

	    return randomNum;
	}
}
