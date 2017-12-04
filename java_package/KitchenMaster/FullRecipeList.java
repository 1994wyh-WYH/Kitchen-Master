package KitchenMaster;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONException;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * This class reads the full recipe list including detailed directions.
 * The full recipe will be used for further recommendation.
 * @author Yihan
 *
 */
public class FullRecipeList {
	
	private ArrayList<FullRecipe> fullRecipes=new ArrayList<>();
	
	/**
	 * This is the constructor.
	 * //@param fileName, file name of the .json file.
	 * @throws JSONException
	 * @throws IOException
	 */
	public FullRecipeList() throws JSONException, IOException {

		InputStream in = new FileInputStream("full_format_recipes.json");
		
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
	     try {
	       fullRecipes=readArray(reader);
	     } finally {
	       reader.close();
	     }
		
	}
	
	/**
	 * This methods reads the arraylist of full-format recipes.
	 * @param reader, JsonReader for reading the json file.
	 * @return an arraylist of full-format recipes.
	 * @throws IOException
	 */
	public static ArrayList<FullRecipe> readArray(JsonReader reader) throws IOException {
		
	     ArrayList<FullRecipe> recipeList = new ArrayList<>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       recipeList.add(readRecipe(reader));
	     }
	     reader.endArray();
	     return recipeList;
	   }

	/**
	 * This method helps read and construct each full-format recipe.
	 * @param reader, JsonReader for reading the json file.
	 * @return a FullRecipe object.
	 * @throws IOException
	 */
	public static FullRecipe readRecipe(JsonReader reader) throws IOException {
		ArrayList<String> directions=null;
		Double fat=-1.0;
		String date=null;
		ArrayList<String> categories=null; 
		Double calories=-1.0;
		String description=null;
		Double protein=-1.0;
		Double rating=-1.0;
		String title=null;
		ArrayList<String> ingredients=null;
		Double sodium=-1.0;

	     reader.beginObject();
	     while (reader.hasNext()) {
	       String name = reader.nextName();
	       if (name.equals("directions")&& reader.peek() != JsonToken.NULL) {
	         directions = readStringsArray(reader);
	       } else if (name.equals("fat")&& reader.peek() != JsonToken.NULL) {
	         fat = reader.nextDouble();
	       } else if (name.equals("date")&& reader.peek() != JsonToken.NULL) {
		      date = reader.nextString();
	       } else if (name.equals("categories") && reader.peek() != JsonToken.NULL) {
	         categories = readStringsArray(reader);
	       } 
	       else if (name.equals("calories")&& reader.peek() != JsonToken.NULL) {
		        calories = reader.nextDouble();
		       }
	       else if (name.equals("desc") && reader.peek() != JsonToken.NULL) {
			      description = reader.nextString();
		       }
	       else if (name.equals("protein")&& reader.peek() != JsonToken.NULL) {
		         protein = reader.nextDouble();
		       }
	       else if (name.equals("rating")&& reader.peek() != JsonToken.NULL) {
		         rating = reader.nextDouble();
		       }
	       else if (name.equals("title")&& reader.peek() != JsonToken.NULL) {
			      title = reader.nextString();
		       }
	       else if (name.equals("ingredients") && reader.peek() != JsonToken.NULL) {
		         ingredients = readStringsArray(reader);
		       }
	       else if (name.equals("sodium")&& reader.peek() != JsonToken.NULL) {
		         sodium = reader.nextDouble();
		       }
	        else {
	         reader.skipValue();
	       }
	     }
	     reader.endObject();
	     return new FullRecipe(directions, fat,date,categories,calories,description,protein,rating,title, ingredients, sodium);
	   }
	
	/**
	 * This method reads and constructs an arraylist of elements of each array.
	 * @param reader,  JsonReader for reading the json file.
	 * @return an arraylist of objects.
	 * @throws IOException
	 */
	public static ArrayList<String> readStringsArray(JsonReader reader) throws IOException {
	     ArrayList<String> elements = new ArrayList<>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       elements.add(reader.nextString());
	     }
	     reader.endArray();
	     return elements;
	   }
	
	/**
	 * @return the full-format recipe list.
	 */
	public ArrayList<FullRecipe> getFullRecipes() {
		return fullRecipes;
	}
}
