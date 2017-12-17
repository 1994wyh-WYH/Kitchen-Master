package KitchenMaster;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public class Print {

	public static void main(String[] args) throws JSONException, IOException {
		FullRecipeList fr=new FullRecipeList();
		ArrayList<FullRecipe> rs=fr.getFullRecipes();
//		if(rs.isEmpty())
//			System.out.println(1);
		System.out.println(rs.size());
		double m=0;
		for(FullRecipe r:rs) {
			Double c=r.getFat();
			if(m<c) {
				m=c;
			};
		}
		
		System.out.println(m);
		}
	}


