package KitchenMaster;

<<<<<<< HEAD
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
			File file=new File("");
			Scanner in=new Scanner(file);
			while(in.hasNextLine()) {
				seasonings.add(in.nextLine());
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
	public static ArrayList<String> getSeasonings() {
		return seasonings;
	}
=======
public class Seasoning {

>>>>>>> 3b63bb3bec64d6bee12f4fcbf810cc4d449736e6
}
