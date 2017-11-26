package KitchenMaster;

import java.io.File;
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
	public Oil() {
		oils=new ArrayList<>();
		try {
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				oils.add(in.nextLine());
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
	public static ArrayList<String> getOils() {
		return oils;
	}

}
