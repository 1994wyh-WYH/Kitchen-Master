package KitchenMaster;

<<<<<<< HEAD
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class forms an arraylist of all carbs for future use.
 * @author Yihan
 *
 */
public class Carb {
	private static ArrayList<String> carbs;
	
	public Carb() {
		carbs=new ArrayList<>();
		try {
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				carbs.add(in.nextLine());
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns the carbs list.
	 * @return an arraylist of carbs
	 */
	public static ArrayList<String> getCarbs() {
		return carbs;
	}
	
	
=======
public class Carb {

>>>>>>> 3b63bb3bec64d6bee12f4fcbf810cc4d449736e6
}
