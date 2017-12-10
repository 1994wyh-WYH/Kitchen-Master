package KitchenMaster;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

public class Print {
	
	public static ArrayList<String> findTop(ArrayList<String> foodInput, ArrayList<String> type, ArrayList<String> cuisine, int top) throws JSONException, IOException  {
		System.out.println(foodInput);
		System.out.println(type);
		System.out.println(cuisine);
		RecipeList rlc=new RecipeList();
		ArrayList<Recipe> rl=rlc.getRecipes();
		HashMap<String, Integer> map = new HashMap<>();
		for(Recipe recipe:rl) {
			if(checkCuisine(cuisine,recipe.getCuisine())) {
				ArrayList<String> ingredientsList = recipe.getIngredients();
				if(checkContains(foodInput, ingredientsList)) {
					System.out.println(ingredientsList);
					for(String ingredient:ingredientsList) {
						if(!foodInput.contains(ingredient)) {
							if(checkType(type, ingredient)) {
								if(map.containsKey(ingredient)) {
									map.put(ingredient, map.get(ingredient)+1);
								} else {
									map.put(ingredient, 1);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(map.size());
		return findTopN(map, top, new MyComparatorDESC());
	}
	
	static class MyComparatorDESC implements Comparator<Map.Entry<String, Integer>> {
	        @Override
	        public int compare(Map.Entry<String, Integer> map1, Map.Entry<String, Integer> map2) {
	            if (map1.getValue() == map2.getValue()) {
	                return 0;
	            }
	            return map1.getValue() < map2.getValue() ? 1 : -1;
	        }
	    }
	public static ArrayList<String> findTopN(HashMap<String, Integer> map, int top, Comparator comparator) {
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
//		System.out.println(list.size());
        Collections.sort(list, comparator);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < top; i++) {
            result.add(list.get(i).getKey());
        } 
        return result;
	}
	
	
	public static boolean checkContains(ArrayList<String> foodInput, ArrayList<String> ingredientList) {
		for(String input:foodInput) {
			if(!ingredientList.contains(input)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkCuisine(ArrayList<String> cuisineList, String cuisine) {
		if(cuisineList.contains("all")) {
			return true;
		} else if(cuisineList.contains(cuisine)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkType(ArrayList<String> typeList, String ingredient) {
		if(typeList.contains("all")) {
			return true;
		}
		if(typeList.contains("carb")) {
			Carb carb = new Carb();
			if(carb.getCarbs().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("dairy")) {
			Dairy dairy = new Dairy();
			if(dairy.getDairies().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("fruit")) {
			Fruit fruit=new Fruit();
			if(fruit.getFruits().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("meat")) {
			Meat meat = new Meat();
			if(meat.getMeats().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("oil")) {
			Oil oil = new Oil();
			if(oil.getOils().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("other")) {
			Other other = new Other();
			if(other.getOthers().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("seafood")) {
			SeaFood seafood = new SeaFood();
			if(seafood.getSeaFoods().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("seasoning")) {
			Seasoning seasoning = new Seasoning();
			if(seasoning.getSeasonings().contains(ingredient)) {
				return true;
			}
		}
		if(typeList.contains("veggie")) {
			Veggie veggie = new Veggie();
			if(veggie.getVeggies().contains(ingredient)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<FullRecipe> findFullRecipe(ArrayList<FullRecipe> rs, ArrayList<String> ingredients, String orderby) {
		ArrayList<FullRecipe> result = new ArrayList<>();
		for(FullRecipe recipe:rs) {
			ArrayList<String> foodlist = recipe.getIngredients();
			if(foodlist!=null) {
				String ingredientString = foodlist.toString();
				if(checkIngredientInside(ingredientString, ingredients)) {
					result.add(recipe);
				}
			}
		}
		if(orderby == "fat high to low") {
			Collections.sort(result, new MyFatDESCComparator());
		} else if (orderby == "fat low to high") {
			Collections.sort(result, new MyFatASCComparator());
		} else if (orderby == "rating high to low") {
			Collections.sort(result, new MyRatingDESCComparator());
		} else if (orderby == "rating low to high") {
			Collections.sort(result, new MyRatingASCComparator());
		} else if (orderby == "cal high to low") {
			Collections.sort(result, new MyCalDESCComparator());
		} else if (orderby == "cal low to high") {
			Collections.sort(result, new MyCalDESCComparator());
		} else if (orderby == "protein high to low") {
			Collections.sort(result, new MyProteinDESCComparator());
		} else {
			Collections.sort(result, new MyProteinASCComparator());
		}
		return result;
}

	static class MyFatDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getFat() == r2.getFat()) {
                return 0;
            }
            return r1.getFat() < r2.getFat() ? 1 : -1;
        }
    }
	static class MyFatASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getFat() == r2.getFat()) {
                return 0;
            }
            return r1.getFat() > r2.getFat() ? 1 : -1;
        }
    }
	static class MyRatingASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getRating() == r2.getRating()) {
                return 0;
            }
            return r1.getRating() > r2.getRating() ? 1 : -1;
        }
    }
	static class MyRatingDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
        	if (r1.getRating() == r2.getRating()) {
                return 0;
            }
            return r1.getRating() < r2.getRating() ? 1 : -1;
        }
    }
	static class MyCalDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
        	if (r1.getCalories() == r2.getCalories()) {
                return 0;
            }
            return r1.getCalories() < r2.getCalories() ? 1 : -1;
        }
    }
	static class MyCalASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
        	if (r1.getCalories() == r2.getCalories()) {
                return 0;
            }
            return r1.getCalories() > r2.getCalories() ? 1 : -1;
        }
    }
	static class MyProteinDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
        	if (r1.getProtein() == r2.getProtein()) {
                return 0;
            }
            return r1.getProtein() < r2.getProtein() ? 1 : -1;
        }
    }
	static class MyProteinASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
        	if (r1.getProtein() == r2.getProtein()) {
                return 0;
            }
            return r1.getProtein() < r2.getProtein() ? 1 : -1;
        }
    }
 
	public static boolean checkIngredientInside(String ingredientString, ArrayList<String> ingredients) {
		for(String ingre: ingredients) {
			Pattern pattern = Pattern.compile(ingre);
	        Matcher match = (pattern).matcher(ingredientString);
	        if(!match.find()) {
	        		return false;
	        }
		}
		return true;
	}

	public static void main(String[] args) throws JSONException, IOException {
		FullRecipeList fr=new FullRecipeList();
		ArrayList<FullRecipe> rs=fr.getFullRecipes();
		for(FullRecipe recipe: rs) {
			System.out.println(recipe.getCalories());
		}
		ArrayList<String> list = new ArrayList<>();
		list.add("beef");
		list.add("onion");
		list.add("cheese");
		list.add("garlic");
		for (FullRecipe fc: findFullRecipe(rs,list,"cal high to low")) {
			System.out.println(fc.getTitle());
			System.out.println(fc.getDate());
			System.out.println(fc.getCalories());
			System.out.println(fc.getFat());
			System.out.println(fc.getCategories());
			System.out.println(fc.getProtein());
			System.out.println(fc.getIngredients());
			System.out.println(fc.getRating());
			System.out.println(fc.getDescription());
			System.out.println("=======================================================");
		}
	
}
	
}

////		if(rs.isEmpty())
////			System.out.println(1);
//		System.out.println(rs.size());
//		double m=0;
//		for(FullRecipe r:rs) {
//			Double c=r.getFat();
//			if(m<c) {
//				m=c;
//			};
//		}
//		
//		System.out.println(m);
//	RecipeList rlc=new RecipeList();
//	ArrayList<Recipe> rl=rlc.getRecipes();
//	IngredientList il=new IngredientList();
//	ArrayList<Ingredient> i=il.getIngredientList();
//	for(Ingredient ii:i) {
//		System.out.println("Ingredients List : " + ii.getName());
//	}
//	ArrayList<String> cuisinelist = new ArrayList();
//	for(Recipe r:rl) {
//		if(!cuisinelist.contains(r.getCuisine())) {
//			cuisinelist.add(r.getCuisine());
//		}
//	}
//	System.out.println(cuisinelist);
//	
//	ArrayList<String> input = new ArrayList<>();
//	input.add("beef");
//	ArrayList<String> type = new ArrayList<>();
//	type.add("carb");
//	ArrayList<String> cuisine = new ArrayList<>();
//	cuisine.add("all");
//	ArrayList<String> result = findTop(input, type, cuisine, 5);
//	System.out.println(result);
//	}


