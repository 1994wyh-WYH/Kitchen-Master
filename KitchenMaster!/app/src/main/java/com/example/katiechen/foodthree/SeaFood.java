package com.example.katiechen.foodthree;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class forms an arraylist of all sea foods for future use.
 * @author Yihan
 *
 */

public class SeaFood {
	private static ArrayList<String> seaFoods;
	
	/**
	 * This is the constructor of the class.
	 */
	public SeaFood(InputStream inp) {
		seaFoods=new ArrayList<>();
		try {

			Scanner in=new Scanner(inp);

			while(in.hasNextLine()) {
				seaFoods.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the sea foods list.
	 * @return an arraylist of sea foods
	 */
	public ArrayList<String> getSeaFoods() {
		return seaFoods;
	}
}
