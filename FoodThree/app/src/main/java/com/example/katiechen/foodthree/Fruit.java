package com.example.katiechen.foodthree;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Fruit {
	private static ArrayList<String> fruits;
	/**
	 * This is the constructor of the class.
	 */
	public Fruit(InputStream inp) {
		fruits=new ArrayList<>();
		try {

			Scanner in=new Scanner(inp);

			while(in.hasNextLine()) {
				fruits.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the dairy list.
	 * @return an arraylist of dairies
	 */
	public ArrayList<String> getFruits() {
		return fruits;
	}
}
