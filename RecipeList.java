/**
 * This class reads the recipe .json file and constructs a list of recipes.
 */
package KitchenMaster;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.tools.JavaFileObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import org.json.JSONStringer;



/**
 * @author Yihan
 *
 */
public class RecipeList {
	private ArrayList<Recipe> recipes;
	private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Recipe>>() {
	}.getType();

	public RecipeList(String fileName) throws JSONException, IOException {
		
		recipes=new ArrayList<>();

		InputStream in = new FileInputStream("train.json");
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
	     try {
	       recipes=readArray(reader);
	     } finally {
	       reader.close();
	     }
		
	}
	
	public ArrayList<Recipe> readArray(JsonReader reader) throws IOException {
	     ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       recipeList.add(readRecipe(reader));
	     }
	     reader.endArray();
	     return recipeList;
	   }

	public Recipe readRecipe(JsonReader reader) throws IOException {
	     int id = -1;
	     String cuisine = null;
	     ArrayList<String> ingredients = null;

	     reader.beginObject();
	     while (reader.hasNext()) {
	       String name = reader.nextName();
	       if (name.equals("id")) {
	         id = reader.nextInt();
	       } else if (name.equals("cuisine")) {
	         cuisine = reader.nextString();
	       } else if (name.equals("ingredients") && reader.peek() != JsonToken.NULL) {
	         ingredients = readStringsArray(reader);
	       } 
	        else {
	         reader.skipValue();
	       }
	     }
	     reader.endObject();
	     return new Recipe(id, cuisine, ingredients);
	   }
	
	public ArrayList<String> readStringsArray(JsonReader reader) throws IOException {
	     ArrayList<String> ingredients = new ArrayList<>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       ingredients.add(reader.nextString());
	     }
	     reader.endArray();
	     return ingredients;
	   }
	
	/**
	 * @return the recipes
	 */
	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}
	
	
}
