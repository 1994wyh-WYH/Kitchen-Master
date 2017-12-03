package KitchenMaster;
/**
 * This class represents an ingredient object.
 * @author Yihan
 *
 */
public class Ingredient {
	private String name;
	private String category;
	
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
		
		for(String temp:Fruit.getFruits()) {
			if(temp.equals(name)) {
				this.category="Fruit";
			}
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	
}
