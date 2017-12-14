package KitchenMaster;

import java.util.ArrayList;

/**
 * This class represents a full recipe object, including  
 * @author Yihan
 *
 */
public class FullRecipe {
	private ArrayList<String> directions;
	private Double fat;
	private String date;
	private ArrayList<String> categories; // ingredient key words, type, brief description.
	private Double calories;
	private String description;
	private Double protein;
	private Double rating;
	private String title;
	private ArrayList<String> ingredients; //full format, not just names of ingredients.
	private Double sodium;
	
	/** This is the constructor
	 * @param directions, cooking directions.
	 * @param fat, fat in grams.
	 * @param date, date created.
	 * @param categories, including ingredient key words, type and brief description.
	 * @param calories, how many calories in one dish.
	 * @param description, descriptions.
	 * @param protein, protein in grams.
	 * @param rating, rating out of 5 stars.
	 * @param title, brief dish title.
	 * @param ingredients, full format ingredient list.
	 */
	public FullRecipe(ArrayList<String> directions, Double fat, String date, ArrayList<String> categories, Double calories,
			String description, Double protein, Double rating, String title, ArrayList<String> ingredients, Double sodium) {
		this.directions = directions;
		this.fat = fat;
		this.date = date;
		this.categories = categories;
		this.calories = calories;
		this.description = description;
		this.protein = protein;
		this.rating = rating;
		this.title = title;
		this.ingredients = ingredients;
		this.sodium=sodium;
	}

	/**
	 * @return the directions
	 */
	public ArrayList<String> getDirections() {
		return directions;
	}

	/**
	 * @return the fat
	 */
	public Double getFat() {
		return fat;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the categories
	 */
	public ArrayList<String> getCategories() {
		return categories;
	}

	/**
	 * @return the calories
	 */
	public Double getCalories() {
		return calories;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the protein
	 */
	public Double getProtein() {
		return protein;
	}

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the ingredients
	 */
	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	/**
	 * @return the sodium
	 */
	public Double getSodium() {
		return sodium;
	}
	
	
	
}
