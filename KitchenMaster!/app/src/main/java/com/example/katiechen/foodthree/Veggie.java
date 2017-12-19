package com.example.katiechen.foodthree;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class forms an arraylist of all veggies for future use.
 * @author Yihan
 *
 */

public class Veggie {
	private static ArrayList<String> veggies;
	
	/**
	 * This is the constructor of the class.
	 */
	public Veggie(InputStream inp) {
		veggies=new ArrayList<>();
		try {

			Scanner in=new Scanner(inp);

			while(in.hasNextLine()) {
				veggies.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the veggie list.
	 * @return an arraylist of veggies
	 */
	public ArrayList<String> getVeggies() {
		return veggies;
	}
}

