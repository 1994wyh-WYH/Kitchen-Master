package com.example.katiechen.foodthree;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class forms an arraylist of all seasonings for future use.
 * @author Yihan
 *
 */
public class Seasoning {
	private static ArrayList<String> seasonings;
	/**
	 * This is the constructor of the class.
	 */
	public Seasoning() {
		seasonings=new ArrayList<>();
		try {
			File file=new File("seasonings.txt");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				seasonings.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the seasoning list.
	 * @return an arraylist of seasonings
	 */
	public ArrayList<String> getSeasonings() {
		return seasonings;
	}
}
