/**
 * This is the test class for Carb.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class CarbTest {

	@Test
	public void testReadingFile() {
		Carb carb=new Carb();
		ArrayList<String> carbs=carb.getCarbs();
		assertNotNull(carbs);
	}

}
