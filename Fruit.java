package KitchenMaster;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Fruit {
	private static ArrayList<String> fruits;
	/**
	 * This is the constructor of the class.
	 */
	public Fruit() {
		fruits=new ArrayList<>();
		try {
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				fruits.add(in.nextLine());
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
	public static ArrayList<String> getFruits() {
		return fruits;
	}
}
