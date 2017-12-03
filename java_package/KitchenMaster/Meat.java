package KitchenMaster;

import java.io.File;
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
	public Meat() {
		meats=new ArrayList<>();
		try {
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				meats.add(in.nextLine());
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
	public static ArrayList<String> getMeats() {
		return meats;
	}

}
