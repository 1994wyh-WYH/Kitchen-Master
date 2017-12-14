package KitchenMaster;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import com.google.gson.stream.JsonReader;

public class FullRecipeListTest {
	private JsonReader reader;
	@Before 
	public void constructReader() throws FileNotFoundException, UnsupportedEncodingException {
		InputStream in = new FileInputStream("full_format_recipes.json");
		reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
	}
	@Test
	public void testReadArray() throws IOException {
		ArrayList<FullRecipe> fullRecipes=null;
		try {
		       fullRecipes=FullRecipeList.readArray(reader);
		     } finally {
		       reader.close();
		     }
		assertNotNull(fullRecipes);
	}

}

