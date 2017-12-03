package KitchenMaster;

import java.io.File;
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
	public Veggie() {
		veggies=new ArrayList<>();
		try {
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				veggies.add(in.nextLine());
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
	public static ArrayList<String> getVeggies() {
		return veggies;
	}
}

