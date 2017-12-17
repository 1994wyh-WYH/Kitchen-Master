/**
 * This is the test class for Other class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class OtherTest {

	@Test
	public void test() {
		Other other=new Other();
		ArrayList<String> others=other.getOthers();
		assertNotNull(others);
	}

}
