package com.example.katiechen.foodthree;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class forms an arraylist of all kinds of oils for future use.
 * @author Yihan
 *
 */
public class Oil {

	private static ArrayList<String> oils;
	/**
	 * This is the constructor of the class.
	 */
	public Oil(InputStream inp) {
		oils=new ArrayList<>();
		try {

			//File file=new File("oils.txt");
			Scanner in=new Scanner(inp);

			while(in.hasNextLine()) {
				oils.add(in.nextLine().toLowerCase());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the oil list.
	 * @return an arraylist of oils
	 */
	public ArrayList<String> getOils() {
		return oils;
	}

}
