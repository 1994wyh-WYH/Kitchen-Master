/**
 * This is the test class for Ingredient class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class IngredientTest {
	private Ingredient ingredient;
	/**
	 * This is the constructor of the object.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ingredient=new Ingredient("water");
	}
	
	@Test
	public void testGetName() {
		assertEquals(ingredient.getName(), "water");
	}
	
	@Test
	public void testGetCategory() {
		assertNotNull(ingredient.getCategory());
	}

}
