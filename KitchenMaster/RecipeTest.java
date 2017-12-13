/**
 * This is the test class for Recipe class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class RecipeTest {
	private Recipe recipe;
	
	/**
	 * This is the constructor of the object.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ArrayList<String> ingredients=new ArrayList<>();
		recipe=new Recipe(1,"Italian",ingredients);
	}
	/**
	 * This is the test case for getiD()
	 */
	@Test
	public void testGetiD() {
		assertEquals(recipe.getiD(), 1);
	}
	/**
	 * This is the test case for getCuisine()
	 */
	@Test
	public void testGetCuisine() {
		assertEquals(recipe.getCuisine(), "Italian");
	}
	/**
	 * This is the test case for getIngredients()
	 */
	@Test
	public void testGetIngredients() {
		assertNotNull(recipe.getIngredients());
	}
}
