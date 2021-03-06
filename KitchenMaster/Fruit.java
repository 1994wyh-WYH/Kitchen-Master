package KitchenMaster;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class forms an arraylist of all fruits for future use.
 * @author Yihan
 *
 */
public class Fruit {
	private static ArrayList<String> fruits;
	/**
	 * This is the constructor of the class.
	 */
	public Fruit() {
		fruits=new ArrayList<>();
		try {
			File file=new File("fruits.txt");
			Scanner in=new Scanner(file);
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
