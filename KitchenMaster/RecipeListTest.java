package KitchenMaster;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.stream.JsonReader;

public class RecipeListTest {
	private JsonReader reader;
	@Before 
	public void constructReader() throws FileNotFoundException, UnsupportedEncodingException {
		InputStream in = new FileInputStream("train.json");
		reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
	}
	@Test
	public void testReadArray() throws IOException {
		ArrayList<Recipe> Recipes=null;
		try {
		       Recipes=RecipeList.readArray(reader);
		     } finally {
		       reader.close();
		     }
		assertNotNull(Recipes);
	}

}
