package KitchenMaster;
<<<<<<< HEAD
/**
 * This class represents an ingredient object.
 * @author Yihan
 *
 */
public class Ingredient {
	private String name;
	private String category;
//	private String meatList;
//	private String seaaFoodList;
//	private String veggieList;
//	private String seasoningList;
//	private String dairyList;
//	private String oilList;
//	private String carbList;
//	private String otherList;
	
	public Ingredient(String name) {
		this.name = name;
		
		for(String temp:Carb.getCarbs()) {
			if(temp.equals(name)) {
				this.category="Carb";
			}
		}
		
		for(String temp:Dairy.getDairies()) {
			if(temp.equals(name)) {
				this.category="Dairy";
			}
		}
		
		for(String temp:Meat.getMeats()) {
			if(temp.equals(name)) {
				this.category="Meat";
			}
		}
		
		for(String temp:Oil.getOils()) {
			if(temp.equals(name)) {
				this.category="Oil";
			}
		}
		for(String temp:Other.getOthers()) {
			if(temp.equals(name)) {
				this.category="Other";
			}
		}
		
		for(String temp:SeaFood.getSeaFoods()) {
			if(temp.equals(name)) {
				this.category="Sea Food";
			}
		}
		
		for(String temp:Seasoning.getSeasonings()) {
			if(temp.equals(name)) {
				this.category="Seasoning";
			}
		}
		
		for(String temp:Veggie.getVeggies()) {
			if(temp.equals(name)) {
				this.category="Veggie";
			}
		}
	}
=======

public class Ingredient {

>>>>>>> 3b63bb3bec64d6bee12f4fcbf810cc4d449736e6
}
