package KitchenMaster;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.JSONException;

public class Print {

	public static void main(String[] args) throws JSONException, IOException {
		RecipeList rl=new RecipeList("train.json");
		ArrayList<Recipe> rs=rl.getRecipes();
		for(Recipe r:rs) {
			System.out.println(r.getCuisine());
		}
		
		
//		String path = "train.json";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//
//        Gson gson = new Gson();
//        Object json = gson.fromJson(bufferedReader, Object.class);
//
//        System.out.println(json.getClass());
//        System.out.println(json.toString());
		
		
		
		
//	    JsonReader jsonReader = new JsonReader(new FileReader("train.json"));
//
//	    jsonReader.beginObject();
//
//	    while (jsonReader.hasNext()) {
//
//	    String name = jsonReader.nextName();
//	        if (name.equals("recipe")) {
//	             readApp(jsonReader);
//
//	        }
//	    }
//
//	   jsonReader.endObject();
//	   jsonReader.close();
//
//	}
//
//	public static void readApp(JsonReader jsonReader) throws IOException{
//	    jsonReader.beginObject();
//	    jsonReader.setLenient(true);
//	     while (jsonReader.hasNext()) {
//	    	 	jsonReader.setLenient(true);
////	         String name = jsonReader.nextName();
////	         System.out.println(name);
//	         if (true){
//	             jsonReader.beginObject();
//	             while (jsonReader.hasNext()) {
//	                 String n = jsonReader.nextName();
//	                 if (n.equals("id")){
//	                     System.out.println(jsonReader.nextString());
//	                 }
//	                 if (n.equals("cuisine")){
//	                     System.out.println(jsonReader.nextInt());
//	                 }
//	                 if (n.equals("ingredients")){
//	                     jsonReader.beginArray();
//	                     while  (jsonReader.hasNext()) {
//	                          System.out.println(jsonReader.nextString());
//	                     }
//	                     jsonReader.endArray();
//	                 }
//	             }
//	             jsonReader.endObject();
//	         }
//
//	     }
//	     jsonReader.endObject();
//	}
	}
	}


