package com.example.katiechen.foodthree;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONException;
/**
 * This class gets the all distinct ingredients from original recipe list, forming a list of full Ingredient objects.
 * Relationships between ingredients and their categories are formed.
 * @author Yihan
 *
 */
public class IngredientList {
	private static ArrayList<Ingredient> ingredientList;
	
	/**
	 * This is the constructor.
	 * @throws JSONException
	 * @throws IOException
	 */
	public IngredientList() throws JSONException, IOException {
		ingredientList=new ArrayList<>();
		RecipeList rl=new RecipeList();
		ArrayList<Recipe> rs=rl.getRecipes();
		ArrayList<String> ingredients=new ArrayList<>();
		for(Recipe r:rs) {
			ArrayList<String> i=r.getIngredients();
			for(String name:i) {
			if(!ingredients.contains(name)) {
				ingredients.add(name);
				Ingredient temp=new Ingredient(name);
				ingredientList.add(temp);
				}
			}
		}
		
	}

	/**
	 * @return the ingredientList
	 */
	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}
	
	
}
