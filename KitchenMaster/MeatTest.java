/**
 * This is the test class for Meat class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class MeatTest {

	@Test
	public void test() {
		Meat meat=new Meat();
		ArrayList<String> meats=meat.getMeats();
		assertNotNull(meats);
	}

}