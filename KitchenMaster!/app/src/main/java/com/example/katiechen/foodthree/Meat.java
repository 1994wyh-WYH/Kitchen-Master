package com.example.katiechen.foodthree;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class forms an arraylist of all meats for future use.
 * @author Yihan
 *
 */
public class Meat {
	private static ArrayList<String> meats;
	
	/**
	 * This is the constructor of the class.
	 */
	public Meat(InputStream inp) {
		meats=new ArrayList<>();
		try {

			Scanner in=new Scanner(inp);

			while(in.hasNextLine()) {
				meats.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the meat list.
	 * @return an arraylist of meats
	 */
	public ArrayList<String> getMeats() {
		return meats;
	}

}
