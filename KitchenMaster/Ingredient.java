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
		
		Meat meat=new Meat();
		for(String temp:meat.getMeats()) {
			if(name.contains(temp)) {
				this.category="Meat";
			}
		}
		Oil oil=new Oil();
		for(String temp:oil.getOils()) {
			if(name.contains(temp)) {
				this.category="Oil";
			}
		}
		Dairy dairy=new Dairy();
		for(String temp:dairy.getDairies()) {
			if(name.contains(temp)) {
				this.category="Dairy";
			}
		}
		SeaFood seafood=new SeaFood();
		for(String temp:seafood.getSeaFoods()) {
			if(name.contains(temp)) {
				this.category="Sea Food";
			}
		}
		Veggie veggie=new Veggie();
		for(String temp:veggie.getVeggies()) {
			if(name.contains(temp)) {
				this.category="Veggie";
			}
		}
		Carb carb=new Carb();
		for(String temp:carb.getCarbs()) {
			if(name.contains(temp)) {
				this.category="Carb";
			}
		}
		Fruit fruit=new Fruit();
		for(String temp:fruit.getFruits()) {
			if(name.contains(temp)) {
				this.category="Fruit";
			}
		}
		Seasoning seasoning=new Seasoning();
		for(String temp:seasoning.getSeasonings()) {
			if(name.contains(temp)) {
				this.category="Seasoning";
			}
		}
		Other other=new Other();
		for(String temp:other.getOthers()) {
			if(name.contains(temp)) {
				this.category="Other";
			}
		}
		if(category==null) {
			this.category="Other";
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
