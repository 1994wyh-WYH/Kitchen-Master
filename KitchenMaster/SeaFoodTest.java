/**
 * This is the test class for SeaFood class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class SeaFoodTest {

	@Test
	public void test() {
		SeaFood seafood=new SeaFood();
		ArrayList<String> seafoods=seafood.getSeaFoods();
		assertNotNull(seafoods);
	}

}
