package com.example.katiechen.foodthree;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;


import org.json.JSONException;


import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;



/**
 * This class reads the .json file of raw recipes and creates a list of recipes.
 * @author Yihan
 *
 */
public class RecipeList {
	private static ArrayList<Recipe> recipes;
	
	
	/**
	 * This is the constructor.
	 * @param fileName, file name of the .json file.
	 * @throws JSONException
	 * @throws IOException
	 */
	public RecipeList(InputStream fileName) throws JSONException, IOException {
		
		recipes=new ArrayList<>();

		//InputStream in = new FileInputStream("train.json");
		JsonReader reader = new JsonReader(new InputStreamReader(fileName, "UTF-8"));
	     try {
	       recipes=readArray(reader);
	     } finally {
	       reader.close();
	     }
		
	}
	public RecipeList() throws JSONException, IOException {

		recipes=new ArrayList<>();

		InputStream in = new FileInputStream("train.json");
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		try {
			recipes=readArray(reader);
		} finally {
			reader.close();
		}

	}
	
	/**
	 * This methods reads the arraylist of recipes.
	 * @param reader, JsonReader for reading the json file.
	 * @return an arraylist of recipes.
	 * @throws IOException
	 */
	public ArrayList<Recipe> readArray(JsonReader reader) throws IOException {
	     ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       recipeList.add(readRecipe(reader));
	     }
	     reader.endArray();
	     return recipeList;
	   }

	/**
	 * This method helps read and construct each recipe.
	 * @param reader, JsonReader for reading the json file.
	 * @return a Recipe object.
	 * @throws IOException
	 */
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
	
	/**
	 * This method reads and constructs an arraylist of ingredients of each recipe.
	 * @param reader,  JsonReader for reading the json file.
	 * @return an arraylist of Ingredient objects.
	 * @throws IOException
	 */
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
