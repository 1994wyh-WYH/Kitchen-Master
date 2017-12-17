package KitchenMaster;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Test;
/**
 * This is the test class for IngredientList class.
 * @author Yihan
 *
 */
  
public class IngredientListTest {
	

	@Test
	public void test() throws JSONException {
		IngredientList il = null;
		try {
			il = new IngredientList();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		ArrayList<Ingredient> i=il.getIngredientList();
		assertNotNull(i);
	}

}
