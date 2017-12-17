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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodlist = getIntent().getStringArrayListExtra(MainIngreInputActivity.FOODLIST);
        String food = "";
        for (String f : foodlist) {
            food = food + f + " ";
        }
        String category = "";
        catlist = getIntent().getStringArrayListExtra(MainCategoryActivity.CATLIST);
        if (catlist.contains("all")) {
            category = "ingredients";
        } else {
            for (String cat : catlist) {
                category += cat + " ";
            }
        }
        String cuisine = "";
        cuisinelist = getIntent().getStringArrayListExtra(MainCuisineActivity.CUISINE);
        if (cuisinelist.contains("all")) {
            cuisine = "all cuisines";
        } else {
            for (String cuis : cuisinelist) {
                cuisine += cuis + " ";
            }
        }

        rank = getIntent().getStringExtra(MainRankActivity.RANK);
        ((TextView) findViewById(R.id.showfood)).setText("The top " + rank.toString() + " " + category + " to go with " + food + " among " + cuisine + " are (is): ");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        InputStream in = getResources().openRawResource(R.raw.train);
        Resources reso = getResources();
        try {
            RecipeList rlc = new RecipeList(in);
            ArrayList<Recipe> recipeList = rlc.getRecipes();
            final ArrayList<String> res = findTop(recipeList, foodlist, catlist, cuisinelist, Integer.parseInt(rank), reso);

            //if Array
            if (res == null || res.size() == 0) {
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

            } else if (res.size() == 1) {
                ((CheckBox) findViewById(R.id.check1)).setText(res.get(0).toString());
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll1.removeAllViews();

            } else if (res.size() == 2) {
                ((CheckBox) findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox) findViewById(R.id.check2)).setText(res.get(1).toString());
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();

            } else if (res.size() == 3) {
                ((CheckBox) findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox) findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox) findViewById(R.id.check3)).setText(res.get(2).toString());
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();

            } else if (res.size() == 4) {
                ((CheckBox) findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox) findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox) findViewById(R.id.check3)).setText(res.get(2).toString());
                ((CheckBox) findViewById(R.id.check4)).setText(res.get(3).toString());
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();

            } else {
                ((CheckBox) findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox) findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox) findViewById(R.id.check3)).setText(res.get(2).toString());
                ((CheckBox) findViewById(R.id.check4)).setText(res.get(3).toString());
                ((CheckBox) findViewById(R.id.check5)).setText(res.get(4).toString());

            }
            if (res.size() != 0) {
                if (res.size() < Integer.parseInt(rank)) {
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
        } catch (Exception e) {
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

        }
    }

    public void setData(Intent intent, ArrayList<String> result) {
        ingredientsList = new ArrayList<>();
        if (result.size() > 0) {
            CheckBox check1 = findViewById(R.id.check1);
            if (check1.isChecked()) {
                ingredientsList.add(result.get(0).toLowerCase());

            }
        }
        if (result.size() > 1) {
            CheckBox check2 = findViewById(R.id.check2);
            if (check2.isChecked()) {
                ingredientsList.add(result.get(1).toLowerCase());

            }
        }
        if (result.size() > 2) {
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
        if (result.size() > 4) {
            CheckBox check5 = findViewById(R.id.check5);
            if (check5.isChecked()) {
                ingredientsList.add(result.get(4).toLowerCase());

            }
        }
        System.out.println(ingredientsList.toString());
        for (String foodinput : foodlist) {
            System.out.println(foodinput);
            ingredientsList.add(foodinput);
        }
        intent.putExtra(INGREDIENTS, ingredientsList);
        intent.putExtra(MainIngreInputActivity.FOODLIST, foodlist);
        intent.putExtra(MainCategoryActivity.CATLIST, catlist);
        intent.putExtra(MainCuisineActivity.CUISINE, cuisinelist);
        intent.putExtra(MainRankActivity.RANK, rank);
    }


    /**
     * Find Top N ingredients according to the food input
     *
     * @param recipeList recipe list of all the recipe inside
     * @param foodInput  the food user input before
     * @param type
     * @param cuisine
     * @param top        the rank N, if user choose top 5, so top = 5
     * @param reso
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public static ArrayList<String> findTop(ArrayList<Recipe> recipeList, ArrayList<String> foodInput, ArrayList<String> type, ArrayList<String> cuisine, int top, Resources reso) throws JSONException, IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (Recipe recipe : recipeList) {
            if (checkCuisine(cuisine, recipe.getCuisine().toLowerCase())) {
                ArrayList<String> ingredientsList = recipe.getIngredients();
                if (checkContains(foodInput, ingredientsList)) {
                    for (String ingredient : ingredientsList) {
                        if (!foodInput.contains(ingredient)) {
                            if (checkType(type, ingredient, reso)) {
                                if (ifAddHashMapp(foodInput, ingredient)) {
                                    if (map.containsKey(ingredient)) {
                                        map.put(ingredient, map.get(ingredient) + 1);
                                    } else {
                                        map.put(ingredient, 1);
                                    }
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
        for (String input : foodinput) {
            if (ingredient.contains(" " + input) || ingredient.contains(input + "s") || ingredient.contains(input + "es")) {
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
        if (map.size() == 0) {
            return new ArrayList<String>();
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
//		System.out.println(list.size());
        Collections.sort(list, comparator);
        ArrayList<String> result = new ArrayList<>();
        if (list.size() < top) {
            top = list.size();
        }
        for (int i = 0; i < top; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }


    public static boolean checkContains(ArrayList<String> foodInput, ArrayList<String> ingredientList) {
        String ingreStr = ingredientList.toString();
        for (String input : foodInput) {
            if (!ingreStr.contains(input)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCuisine(ArrayList<String> cuisineList, String cuisine) {
        if (cuisineList.contains("all")) {
            return true;
        } else if (cuisineList.contains(cuisine)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkType(ArrayList<String> typeList, String ingredient, Resources res) {
        if (typeList.contains("all")) {
            return true;
        }

        if (typeList.contains("carb")) {
            InputStream carbi = res.openRawResource(R.raw.carbs);
            Carb carb = new Carb(carbi);
            for (String c : carb.getCarbs()) {
                if (ingredient.equals(c)) {
                    return true;
                }
            }
        }
        if (typeList.contains("dairy")) {
            InputStream dairyi = res.openRawResource(R.raw.dairies);
            Dairy dairy = new Dairy(dairyi);
            for (String d : dairy.getDairies()) {
                if (ingredient.equals(d)) {
                    return true;
                }
            }
        }
        if (typeList.contains("fruit")) {
            InputStream fruiti = res.openRawResource(R.raw.fruits);
            Fruit fruit = new Fruit(fruiti);
            for (String f : fruit.getFruits()) {
                if (ingredient.equals(f)) {
                    return true;
                }
            }
        }
        if (typeList.contains("meat")) {
            InputStream meati = res.openRawResource(R.raw.meats);
            Meat meat = new Meat(meati);
            for (String m : meat.getMeats()) {
                if (ingredient.equals(m)) {
                    return true;
                }
            }
        }
        if (typeList.contains("oil")) {
            InputStream oili = res.openRawResource(R.raw.oils);
            Oil oil = new Oil(oili);
            for (String o : oil.getOils()) {
                if (ingredient.equals(o)) {
                    return true;
                }
            }
        }
        if (typeList.contains("other")) {
            InputStream otheri = res.openRawResource(R.raw.others);
            Other other = new Other(otheri);
            for (String o : other.getOthers()) {
                if (ingredient.equals(o)) {
                    return true;
                }
            }
        }
        if (typeList.contains("seafood")) {
            InputStream seafoodi = res.openRawResource(R.raw.seafoods);
            SeaFood seafood = new SeaFood(seafoodi);
            for (String s : seafood.getSeaFoods()) {
                if (ingredient.equals(s)) {
                    return true;
                }
            }
        }
        if (typeList.contains("seasoning")) {
            InputStream seasoningi = res.openRawResource(R.raw.seasonings);
            Seasoning seasoning = new Seasoning(seasoningi);
            for (String s : seasoning.getSeasonings()) {
                if (ingredient.equals(s)) {
                    return true;
                }
            }
        }
        if (typeList.contains("veggie")) {
            InputStream veggiei = res.openRawResource(R.raw.veggies);
            Veggie veggie = new Veggie(veggiei);
            for (String v : veggie.getVeggies()) {
                if (ingredient.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Android studio API method, used to get back to previous activity
     *
     * @param item
     * @return ture if click the go back button, false otherwise
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


}