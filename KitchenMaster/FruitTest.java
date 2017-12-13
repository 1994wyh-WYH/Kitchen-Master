/**
 * This is the test class for Fruit class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class FruitTest {

	@Test
	public void test() {
		Fruit fruit=new Fruit();
		ArrayList<String> fruits=fruit.getFruits();
		assertNotNull(fruits);
	}

}