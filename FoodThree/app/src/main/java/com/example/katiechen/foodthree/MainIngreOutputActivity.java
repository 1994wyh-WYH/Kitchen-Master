package com.example.katiechen.foodthree;

import android.content.Intent;
import android.content.res.Resources;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class MainIngreOutputActivity extends AppCompatActivity {

    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;
    public String rank;
    public ArrayList<String> ingredientsList;
    public static final String INGREDIENTS = "ingredients";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
        foodlist = getIntent().getStringArrayListExtra(MainIngreInputActivity.FOODLIST);
        String food = "";
        for(String f:foodlist) {
            food = food + f + " ";
        }
        String category = "";
        catlist = getIntent().getStringArrayListExtra(MainCategoryActivity.CATLIST);
        if(catlist.contains("all")) {
            category = "ingredients";
        } else {
            for(String cat:catlist) {
                category += cat + " ";
            }
        }
        String cuisine = "";
        cuisinelist = getIntent().getStringArrayListExtra(MainCuisineActivity.CUISINE);
        if(cuisinelist.contains("all")) {
            cuisine = "all cuisines";
        } else {
            for(String cuis:cuisinelist) {
                cuisine += cuis + " ";
            }
        }

        rank = getIntent().getStringExtra(MainRankActivity.RANK);
        ((TextView) findViewById(R.id.showfood)).setText("The top " + rank.toString() + " "+  category + " to go with " + food + " among "+ cuisine + " are (is): ");
=======
        foodlist = getIntent().getStringArrayListExtra(Main2Activity.FOODLIST);
        String food = "";
        for(String f:foodlist) {
            food = food + f + " ";
        }
        String category = "";
        catlist = getIntent().getStringArrayListExtra(Main3Activity.CATLIST);
        if(catlist.contains("all")) {
            category = "Ingredients";
        } else {
            for(String cat:catlist) {
                category += cat + " ";
            }
        }
        String cuisine = "";
        cuisinelist = getIntent().getStringArrayListExtra(Main4Activity.CUISINE);
        if(cuisinelist.contains("all")) {
            cuisine = "All Cuisines ";
        } else {
            for(String cuis:cuisinelist) {
                cuisine += cuis + " ";
            }
        }

        rank = getIntent().getStringExtra(Main5Activity.RANK);
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
        ((TextView) findViewById(R.id.showfood)).setText("The Top " + rank.toString() + " "+  category + " Go With " + food + " Among "+ cuisine + " Are: ");
=======
        ((TextView) findViewById(R.id.showfood)).setText("The Top " + rank.toString() +  catlist.toString() + "To Go With " +foodlist.toString() + " Among "+ cuisinelist.toString());
//        ((TextView) findViewById(R.id.showcat)).setText(catlist.toString());
//        ((TextView) findViewById(R.id.showcuisine)).setText(cuisinelist.toString());
//        ((TextView) findViewById(R.id.rank)).setText(rank.toString());

        //((TextView) findViewById(R.id.showtest)).setText("Hello");
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java

        try{
            TestClass tc = new TestClass();
            //((TextView) findViewById(R.id.showtest)).setText(tc.getText());
        } catch(Exception e){
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        InputStream in2 = getResources().openRawResource(R.raw.train);
        //InputStream carbi = getResources().openRawResource(R.raw.carbs);
        Resources reso = getResources();
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            RecipeList rlc=new RecipeList(in2);
            ArrayList<Recipe> rl=rlc.getRecipes();
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java

            final ArrayList<String> res = findTop(rl, foodlist,catlist,cuisinelist,Integer.parseInt(rank), reso);
            if(res==null||res.size()==0){
                ((TextView) findViewById(R.id.Error)).setText("Oooops!\nCannot Find Ingredient!\nPlease Go Back to Input Again!");
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll1.removeAllViews();
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout1);
                lll.removeAllViews();

            } else if(res.size() == 1) {
=======
            //((TextView) findViewById(R.id.showtest)).setText(foodlist.get(0));
            //((TextView) findViewById(R.id.showtest2)).setText(catlist.get(0));
            //((TextView) findViewById(R.id.showtest3)).setText(cuisinelist.get(0));
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java

            final ArrayList<String> res = findTop(rl, foodlist,catlist,cuisinelist,Integer.parseInt(rank), reso);
            if(res==null||res.size()==0){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                ((TextView) findViewById(R.id.Error)).setText("Oooops!\nCannot Find Ingredient!\nPlease Go Back to Input Again!");
=======
                System.out.println("no recipe!!!!!!!!!!!");
                ((TextView) findViewById(R.id.bbb)).setText("no recipe found!");
                return;
            }
            //((TextView) findViewById(R.id.showrecipe)).setText(res.toString());
//            LinearLayout ll = (LinearLayout) findViewById(R.id.crappy_list);
//            ll.removeAllViews();
//            for(String r:res) {
//                View view = getListItemView(r);
//                ll.addView(view);
//            }
            if(res.size() == 1) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                ll1.removeAllViews();
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout1);
                lll.removeAllViews();

            } else if(res.size() == 1) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll1.removeAllViews();

=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                ll1.removeAllViews();

=======
                ll.removeAllViews();
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
            } else if(res.size() == 2) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();

            } else if(res.size() == 3) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText(res.get(2).toString());
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();

            } else if(res.size() == 4) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText(res.get(2).toString());
                ((CheckBox)findViewById(R.id.check4)).setText(res.get(3).toString());
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();

            } else {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText(res.get(2).toString());
                ((CheckBox)findViewById(R.id.check4)).setText(res.get(3).toString());
                ((CheckBox)findViewById(R.id.check5)).setText(res.get(4).toString());
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java

=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java

            }
            if(res.size()!= 0) {
                if(res.size()<Integer.parseInt(rank)){
                    ((TextView) findViewById(R.id.Error)).setText("Recipes containing such combination are fewer than you expected!");
                } else {
                    LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                    lll.removeAllViews();
                }
=======
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
            }
            if(res.size()!= 0) {
                if(res.size()<Integer.parseInt(rank)){
                    ((TextView) findViewById(R.id.Error)).setText("Recipes containing such combination are fewer than you expected!");
                } else {
                    LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                    lll.removeAllViews();
                }
            }
            Button startButton = findViewById(R.id.bbb);
            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainIngreOutputActivity.this, MainRecipeRankActivity.class);
                    setData(intent, res);
                    startActivity(intent);
                }
            });
            Button rButton = findViewById(R.id.random);
            rButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainIngreOutputActivity.this, MainRandomRecipeActivity.class);
                    setData(intent, res);
                    startActivity(intent);
                }
            });
            Button rButton = findViewById(R.id.random);
            rButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Main6Activity.this, Main8Activity.class);
                    setData(intent, res);
                    startActivity(intent);
                }
            });
        } catch (Exception e){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
            ((TextView) findViewById(R.id.Error)).setText("Oooops!\n Cannot Find Ingredient!\n Please Go Back to Input Again!");
            LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
            ll.removeAllViews();
            LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
            ll2.removeAllViews();
            LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
            ll3.removeAllViews();
            LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
            ll1.removeAllViews();
            LinearLayout lll = (LinearLayout) findViewById(R.id.layout1);
            lll.removeAllViews();

<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
        }
    }


    public void setData(Intent intent, ArrayList<String> result) {
=======
        }
    }
=======
            //((TextView) findViewById(R.id.showtest)).setText("nitama5");
            ((TextView) findViewById(R.id.Error)).setText(("trouble reading JSON"));
        }
    }
//    @NonNull
//    private View getListItemView(@NonNull String r) {
//        View view = getLayoutInflater().inflate(R.layout.content_main8, null);
//        ((TextView)view.findViewById(R.id.check)).setText(r.toString());
//        return view;
//    }
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java

    public void setData(Intent intent, ArrayList<String> result) {
        ingredientsList = new ArrayList<>();
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
        if(result.size() > 0) {
            CheckBox check1 = findViewById(R.id.check1);
            if (check1.isChecked()) {
                ingredientsList.add(result.get(0).toLowerCase());

            }
        }
        if(result.size() > 1) {
            CheckBox check2 = findViewById(R.id.check2);
            if (check2.isChecked()) {
                ingredientsList.add(result.get(1).toLowerCase());

            }
        }
        if(result.size() > 2) {
            CheckBox check3 = findViewById(R.id.check3);
            if (check3.isChecked()) {
                ingredientsList.add(result.get(2).toLowerCase());

            }
        }
        if (result.size() > 3) {
            CheckBox check4 = findViewById(R.id.check4);
            if (check4.isChecked()) {
                ingredientsList.add(result.get(3).toLowerCase());

            }
        }
        if(result.size() > 4) {
            CheckBox check5 = findViewById(R.id.check5);
            if (check5.isChecked()) {
                ingredientsList.add(result.get(4).toLowerCase());

            }
        }
        System.out.println(ingredientsList.toString());
        for(String foodinput:foodlist) {
            System.out.println(foodinput);
            ingredientsList.add(foodinput);
        }
        intent.putExtra(INGREDIENTS, ingredientsList);
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
        intent.putExtra(Main2Activity.FOODLIST, foodlist);
        intent.putExtra(Main3Activity.CATLIST, catlist);
        intent.putExtra(Main4Activity.CUISINE, cuisinelist);
        intent.putExtra(Main5Activity.RANK, rank);
=======
        intent.putExtra(MainIngreInputActivity.FOODLIST, foodlist);
        intent.putExtra(MainCategoryActivity.CATLIST, catlist);
        intent.putExtra(MainCuisineActivity.CUISINE, cuisinelist);
        intent.putExtra(MainRankActivity.RANK, rank);
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
    }
    public static ArrayList<String> findTop(ArrayList<Recipe> rl,ArrayList<String> foodInput, ArrayList<String> type, ArrayList<String> cuisine, int top, Resources reso) throws JSONException, IOException  {
        HashMap<String, Integer> map = new HashMap<>();
        for(Recipe recipe:rl) {
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
=======
            System.out.println(recipe.getCuisine());
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
            if(checkCuisine(cuisine,recipe.getCuisine().toLowerCase())) {
                ArrayList<String> ingredientsList = recipe.getIngredients();
                if(checkContains(foodInput, ingredientsList)) {
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    for(String ingredient:ingredientsList) {
                        if(!foodInput.contains(ingredient)) {
                            if(checkType(type, ingredient, reso)) {
                                if(ifAddHashMapp(foodInput, ingredient)) {
                                    if(map.containsKey(ingredient)) {
                                        map.put(ingredient, map.get(ingredient)+1);
                                    } else {
                                        map.put(ingredient, 1);
                                    }
=======
                    System.out.println("checked contains ingr");
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    for(String ingredient:ingredientsList) {
                        if(!foodInput.contains(ingredient)) {
                            if(checkType(type, ingredient, reso)) {
                                if(map.containsKey(ingredient)) {
                                    map.put(ingredient, map.get(ingredient)+1);
                                } else {
                                    map.put(ingredient, 1);
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
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

    public static boolean ifAddHashMapp(ArrayList<String> foodinput, String ingredient) {
        for(String input:foodinput) {
            if(ingredient.contains(" " + input) || ingredient.contains(input + "s") || ingredient.contains(input + "es")) {
                return false;
            }
        }
        return true;
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
        if(map.size()==0){
            return new ArrayList<String>();
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
//		System.out.println(list.size());
        Collections.sort(list, comparator);
        ArrayList<String> result = new ArrayList<>();
        if(list.size()<top){
            top=list.size();
        }
        for (int i = 0; i < top; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }


    public static boolean checkContains(ArrayList<String> foodInput, ArrayList<String> ingredientList) {
        String ingreStr = ingredientList.toString();
        for(String input: foodInput) {
            if(!ingreStr.contains(input)) {
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

    public static boolean checkType(ArrayList<String> typeList, String ingredient, Resources res) {
        if(typeList.contains("all")) {
            return true;
        }

        if(typeList.contains("carb")) {
            InputStream carbi = res.openRawResource(R.raw.carbs);
            Carb carb = new Carb(carbi);
            for(String c:carb.getCarbs()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(c)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(c)) {
=======
                if (ingredient.equals(c) || c.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
//            if(carb.getCarbs().contains(ingredient)) {
//                return true;
//            }
        }
        if(typeList.contains("dairy")) {
            InputStream dairyi=res.openRawResource(R.raw.dairies);
            Dairy dairy = new Dairy(dairyi);
            for(String d:dairy.getDairies()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(d)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(d)) {
=======
                if (ingredient.equals(d) || d.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("fruit")) {
            InputStream fruiti=res.openRawResource(R.raw.fruits);
            Fruit fruit = new Fruit(fruiti);
            for(String f:fruit.getFruits()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(f)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(f)) {
=======
                if (ingredient.equals(f) || f.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("meat")) {
            InputStream meati=res.openRawResource(R.raw.meats);
            Meat meat = new Meat(meati);
            for(String m:meat.getMeats()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(m)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(m)) {
=======
                if (ingredient.equals(m) || m.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("oil")) {
            InputStream oili=res.openRawResource(R.raw.oils);
            Oil oil = new Oil(oili);
            for(String o:oil.getOils()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(o)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(o)) {
=======
                if (ingredient.equals(o) || o.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("other")) {
            InputStream otheri=res.openRawResource(R.raw.others);
            Other other = new Other(otheri);
            for(String o:other.getOthers()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(o)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(o)) {
=======
                if (ingredient.equals(o) || o.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("seafood")) {
            InputStream seafoodi=res.openRawResource(R.raw.seafoods);
            SeaFood seafood = new SeaFood(seafoodi);
            for(String s:seafood.getSeaFoods()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(s)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(s)) {
=======
                if (ingredient.equals(s) || s.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("seasoning")) {
            InputStream seasoningi=res.openRawResource(R.raw.seasonings);
            Seasoning seasoning = new Seasoning(seasoningi);
            for(String s:seasoning.getSeasonings()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(s)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(s)) {
=======
                if (ingredient.equals(s) || s.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        if(typeList.contains("veggie")) {
            InputStream veggiei=res.openRawResource(R.raw.veggies);
            Veggie veggie = new Veggie(veggiei);
            for(String v:veggie.getVeggies()){
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
                if (ingredient.equals(v)) {
=======
<<<<<<< HEAD:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                if (ingredient.equals(v)) {
=======
                if (ingredient.equals(v) || v.equals(ingredient)) {
>>>>>>> 931af71aff4e1a9d847354aaf4c7e8823eb0c410:FoodThree/app/src/main/java/com/example/katiechen/foodthree/Main6Activity.java
>>>>>>> 9161a51e4967eff3d883cfb85af3d381f8d61cb8:FoodThree/app/src/main/java/com/example/katiechen/foodthree/MainIngreOutputActivity.java
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }




}