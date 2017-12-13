package com.example.katiechen.foodthree;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class forms an arraylist of all other kinds of foods for future use.
 * @author Yihan
 *
 */

public class Other {
private static ArrayList<String> others;
	/**
	 * This is the constructor of the class.
	 */
	public Other(InputStream inp) {
		others=new ArrayList<>();
		try {
			//File file=new File("others.txt");
			Scanner in=new Scanner(inp);
			while(in.hasNextLine()) {
				others.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns other kinds of foods' list.
	 * @return an arraylist of other kinds of foods.
	 */
	public static ArrayList<String> getOthers() {
		return others;
	}
}
