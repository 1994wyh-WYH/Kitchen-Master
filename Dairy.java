package KitchenMaster;

import java.io.File;
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
	public Dairy() {
		dairies=new ArrayList<>();
		try {
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				dairies.add(in.nextLine());
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