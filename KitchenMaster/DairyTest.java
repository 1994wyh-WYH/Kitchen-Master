/**
 * This is the test class for Dairy class.
 */
package KitchenMaster;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Yihan
 *
 */
public class DairyTest {

	@Test
	public void test() {
		Dairy dairy=new Dairy();
		ArrayList<String> dairies=dairy.getDairies();
		assertNotNull(dairies);
	}

}
