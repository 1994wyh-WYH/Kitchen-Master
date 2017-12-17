/**
 * This is the test class for Seasoning class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class SeasoningTest {

	@Test
	public void test() {
		Seasoning seasoning=new Seasoning();
		ArrayList<String> seasonings=seasoning.getSeasonings();
		assertNotNull(seasonings);
	}

}