/**
 * 
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the test for FullRecipe class.
 * @author Yihan
 *
 */
public class FullRecipeTest {
	private FullRecipe fullRecipe;
	
	/**
	 * This is the constructor of the object.
	 */
	@Before
	public void construct() {
		ArrayList<String> directions=new ArrayList<>();
		directions.add("Preheat oven.");
		Double fat=0.0;
		String date="2017-12-12";
		ArrayList<String> categories=new ArrayList<>(); 
		categories.add("Italian");
		Double calories=0.0;
		String description="none";
		Double protein=0.0;
		Double rating=0.0;
		String title="None";
		ArrayList<String> ingredients=new ArrayList<>(); 
		ingredients.add("water");
		Double sodium=0.0;
		this.fullRecipe=new FullRecipe(directions, fat, date, categories, calories, description, protein, rating, title, ingredients, sodium);
	}
	/**
	 * Test case for getDirections()
	 */
	@Test
	public void testGetDirection() {
		assertNotNull(fullRecipe.getDirections());
	}
	/**
	 * Test case for getFat()
	 */
	@Test
	public void testGetFat() {
		assertNotNull(fullRecipe.getFat());
	}
	/**
	 * Test case for getDate()
	 */
	@Test
	public void testGetDate() {
		assertNotNull(fullRecipe.getDate());
	}
	/**
	 * Test case for getCategories()
	 */
	@Test
	public void testGetCategories() {
		assertNotNull(fullRecipe.getCategories());
	}
	/**
	 * Test case for getCalories()
	 */
	@Test
	public void testGetCalories() {
		assertNotNull(fullRecipe.getCalories());
	}
	/**
	 * Test case for getDescription()
	 */
	@Test
	public void testGetDescription() {
		assertNotNull(fullRecipe.getDescription());
	}
	/**
	 * Test case for getProtein()
	 */
	@Test
	public void testGetProtein() {
		assertNotNull(fullRecipe.getProtein());
	}
	/**
	 * Test case for getRating()
	 */
	@Test
	public void testGetRating() {
		assertNotNull(fullRecipe.getRating());
	}
	/**
	 * Test case for getTitle()
	 */
	@Test
	public void testGetTitle() {
		assertNotNull(fullRecipe.getTitle());
	}
	/**
	 * Test case for getIngredients()
	 */
	@Test
	public void testGetIngredients() {
		assertNotNull(fullRecipe.getIngredients());
	}
	/**
	 * Test case for getSodium()
	 */
	@Test
	public void testGetSodium() {
		assertNotNull(fullRecipe.getSodium());
	}
	
}
