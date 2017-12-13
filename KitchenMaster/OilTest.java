/**
 * This is the test class for Oil class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class OilTest {

	@Test
	public void test() {
		Oil oil=new Oil();
		ArrayList<String> oils=oil.getOils();
		assertNotNull(oils);
	}

}