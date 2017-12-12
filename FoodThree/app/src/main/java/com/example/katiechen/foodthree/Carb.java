package com.example.katiechen.foodthree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class forms an arraylist of all carbs for future use.
 * @author Yihan
 *
 */
public class Carb {
	private static ArrayList<String> carbs;
	
	public Carb() {
		carbs=new ArrayList<>();
		try {
			File file=new File("Carbs.txt");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				carbs.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the carbs list.
	 * @return an arraylist of carbs
	 */
	public ArrayList<String> getCarbs() {
		return carbs;
	}
	
	
}
