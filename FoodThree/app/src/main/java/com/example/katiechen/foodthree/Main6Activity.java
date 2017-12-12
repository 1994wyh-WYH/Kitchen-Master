package com.example.katiechen.foodthree;

import android.content.Intent;
import android.content.res.Resources;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Main6Activity extends AppCompatActivity {

    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;
    public String rank;
    public ArrayList<String> ingredientsList = new ArrayList<>();
    public static final String INGREDIENTS = "ingredients";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            cuisine = "All Cuisine ";
        } else {
            for(String cuis:cuisinelist) {
                cuisine += cuis + " ";
            }
        }

        rank = getIntent().getStringExtra(Main5Activity.RANK);
        ((TextView) findViewById(R.id.showfood)).setText("The Top " + rank.toString() + " "+  category + " Go With " + food + " Among "+ cuisine + " Are: ");
//        ((TextView) findViewById(R.id.showcat)).setText(catlist.toString());
//        ((TextView) findViewById(R.id.showcuisine)).setText(cuisinelist.toString());
//        ((TextView) findViewById(R.id.rank)).setText(rank.toString());

        //((TextView) findViewById(R.id.showtest)).setText("Hello");

        try{
            TestClass tc = new TestClass();
            //((TextView) findViewById(R.id.showtest)).setText(tc.getText());
        } catch(Exception e){
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        InputStream in2 = getResources().openRawResource(R.raw.train);
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            RecipeList rlc=new RecipeList(in2);
            ArrayList<Recipe> rl=rlc.getRecipes();
            final ArrayList<String> res = findTop(rl, foodlist,catlist,cuisinelist,Integer.parseInt(rank));
//            ((TextView) findViewById(R.id.showrecipe)).setText(res.toString());
//            LinearLayout ll = (LinearLayout) findViewById(R.id.crappy_list);
//            ll.removeAllViews();
//            for(String r:res) {
//                View view = getListItemView(r);
//                ll.addView(view);
//            }
            System.out.println(res.size());
            if(res.size() == 0) {
                System.out.println("1111aaa");
                ((TextView)findViewById(R.id.Error)).setText("Oooops!\n Cannot Find Ingredient!\n Please Go Back to Input Again!");
                LinearLayout ll4 = (LinearLayout) findViewById(R.id.layout1);
                ll4.removeAllViews();
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll1.removeAllViews();
                LinearLayout llend = (LinearLayout) findViewById(R.id.layoutend);
                llend.removeAllViews();
            }
            if(res.size() == 1) {
                ((CheckBox)findViewById(R.id.check1)).setText("Top 1: " + res.get(0).toString());
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                lll.removeAllViews();
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll1.removeAllViews();
            } else if(res.size() == 2) {
                ((CheckBox)findViewById(R.id.check1)).setText("Top 1: " + res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText("Top 2: " +res.get(1).toString());
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                lll.removeAllViews();
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
            } else if(res.size() == 3) {
                ((CheckBox)findViewById(R.id.check1)).setText("Top 1: " +res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText("Top 2: " +res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText("Top 3: " +res.get(2).toString());
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                lll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
            } else if(res.size() == 4) {
                ((CheckBox)findViewById(R.id.check1)).setText("Top 1: " +res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText("Top 2: " +res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText("Top 3: " +res.get(2).toString());
                ((CheckBox)findViewById(R.id.check4)).setText("Top 4: " +res.get(3).toString());
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                lll.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
            } else {
                ((CheckBox)findViewById(R.id.check1)).setText("Top 1: " +res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText("Top 2: " +res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText("Top 3: " +res.get(2).toString());
                ((CheckBox)findViewById(R.id.check4)).setText("Top 4: " +res.get(3).toString());
                ((CheckBox)findViewById(R.id.check5)).setText("Top 5: " +res.get(4).toString());
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout12);
                lll.removeAllViews();
            }
            Button startButton = findViewById(R.id.bbb);
            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Main6Activity.this, Main7Activity.class);
                    setData(intent, res);
                    startActivity(intent);
                }
            });
        } catch (Exception e){
            System.out.println("222aaa");
            ((TextView)findViewById(R.id.Error)).setText("Oooops!\n Cannot Find Ingredient!\n Please Go Back to Input Again!");
            LinearLayout llend = (LinearLayout) findViewById(R.id.layoutend);
            llend.removeAllViews();
            LinearLayout ll4 = (LinearLayout) findViewById(R.id.layout1);
            ll4.removeAllViews();
            LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
            ll.removeAllViews();
            LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
            ll2.removeAllViews();
            LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
            ll3.removeAllViews();
            LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
            ll1.removeAllViews();
        }
    }


    public void setData(Intent intent, ArrayList<String> result) {
        CheckBox check1 = findViewById(R.id.check1);
        System.out.println("yes");
        if (check1.isChecked()) {
            ingredientsList.add(result.get(0));
            System.out.println("yes1");
        }
        if(result.size() > 1) {
            CheckBox check2 = findViewById(R.id.check2);
            if (check2.isChecked()) {
                ingredientsList.add(result.get(1));
                System.out.println("yes2");
            }
        }
        if(result.size() > 2) {
            CheckBox check3 = findViewById(R.id.check3);
            if (check3.isChecked()) {
                ingredientsList.add(result.get(2));
                System.out.println("yes3");
            }
        }
        if (result.size() > 3) {
            CheckBox check4 = findViewById(R.id.check4);
            if (check4.isChecked()) {
                ingredientsList.add(result.get(3));
                System.out.println("ye4");
            }
        }
        if(result.size() > 4) {
            CheckBox check5 = findViewById(R.id.check5);
            if (check5.isChecked()) {
                ingredientsList.add(result.get(4));
                System.out.println("ye5");
            }
        }
        System.out.println(ingredientsList.toString());
        for(String foodinput:foodlist) {
            System.out.println("yes66");
            System.out.println(foodinput);
            ingredientsList.add(foodinput);
        }
        System.out.println("yes66");
        intent.putExtra(INGREDIENTS, ingredientsList);
        System.out.println("yes77");
    }
    public static ArrayList<String> findTop(ArrayList<Recipe> rl,ArrayList<String> foodInput, ArrayList<String> type, ArrayList<String> cuisine, int top) throws JSONException, IOException  {
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
        Collections.sort(list, comparator);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < top && i < list.size(); i++) {
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }




}
