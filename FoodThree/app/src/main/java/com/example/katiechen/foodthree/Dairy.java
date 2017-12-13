package com.example.katiechen.foodthree;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class forms an arraylist of all dairies for future use.
 * @author Yihan
 *
 */

public class Dairy {
private static ArrayList<String> dairies;
	/**
	 * This is the constructor of the class.
	 */
	public Dairy(InputStream inp) {
		dairies=new ArrayList<>();
		try {
			//File file=new File("dairies.txt");
			Scanner in=new Scanner(inp);
			while(in.hasNextLine()) {
				dairies.add(in.nextLine().toLowerCase());
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
	public static ArrayList<String> getDairies() {
		return dairies;
	}
}