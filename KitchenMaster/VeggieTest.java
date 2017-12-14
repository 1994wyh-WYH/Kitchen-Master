/**
 * This is the test class for Veggie class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class VeggieTest {

	@Test
	public void test() {
		Veggie veggie=new Veggie();
		ArrayList<String> veggies=veggie.getVeggies();
		assertNotNull(veggies);
	}

}