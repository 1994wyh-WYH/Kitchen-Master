package KitchenMaster;

<<<<<<< HEAD
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
=======
public class Oil {

	public Oil() {
		// TODO Auto-generated constructor stub
>>>>>>> 3b63bb3bec64d6bee12f4fcbf810cc4d449736e6
	}

}
