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
		Carb carb=new Carb();
		for(String temp:carb.getCarbs()) {
			if(temp.equals(name)) {
				this.category="Carb";
			}
		}
		Dairy dairy=new Dairy();
		for(String temp:dairy.getDairies()) {
			if(temp.equals(name)) {
				this.category="Dairy";
			}
		}
		Meat meat=new Meat();
		for(String temp:meat.getMeats()) {
			if(temp.equals(name)) {
				this.category="Meat";
			}
		}
		Oil oil=new Oil();
		for(String temp:oil.getOils()) {
			if(temp.equals(name)) {
				this.category="Oil";
			}
		}
		Other other=new Other();
		for(String temp:other.getOthers()) {
			if(temp.equals(name)) {
				this.category="Other";
			}
		}
		SeaFood seafood=new SeaFood();
		for(String temp:seafood.getSeaFoods()) {
			if(temp.equals(name)) {
				this.category="Sea Food";
			}
		}
		Seasoning seasoning=new Seasoning();
		for(String temp:seasoning.getSeasonings()) {
			if(temp.equals(name)) {
				this.category="Seasoning";
			}
		}
		Veggie veggie=new Veggie();
		for(String temp:veggie.getVeggies()) {
			if(temp.equals(name)) {
				this.category="Veggie";
			}
		}
		Fruit fruit=new Fruit();
		for(String temp:fruit.getFruits()) {
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
