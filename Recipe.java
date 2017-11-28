package KitchenMaster;

import java.util.ArrayList;

public class Recipe {
	private int iD;
	private String cuisine;
	private ArrayList<String> ingredients;
	
	/**
	 * This is the constructor of the class.
	 * @param iD, recipe ID.
	 * @param cuisine, cuisine type of the recipe.
	 * @param ingredients, an arrayList of ingredients needed.
	 */
	public Recipe(int iD, String cuisine, ArrayList<String> ingredients) {
		this.iD = iD;
		this.cuisine = cuisine;
		this.ingredients = ingredients;
	}

	/**
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}

	/**
	 * @return the cuisine
	 */
	public String getCuisine() {
		return cuisine;
	}

	/**
	 * @return the ingredients
	 */
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	
	
	
	
}
