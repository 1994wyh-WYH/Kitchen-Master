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


        catlist = getIntent().getStringArrayListExtra(Main3Activity.CATLIST);


        cuisinelist = getIntent().getStringArrayListExtra(Main4Activity.CUISINE);

        rank = getIntent().getStringExtra(Main5Activity.RANK);
        ((TextView) findViewById(R.id.showfood)).setText("The Top " + rank.toString() +  catlist.toString() + "To Go With " +foodlist.toString() + " Among "+ cuisinelist.toString());
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
        //InputStream carbi = getResources().openRawResource(R.raw.carbs);
        Resources reso = getResources();
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            RecipeList rlc=new RecipeList(in2);
            ArrayList<Recipe> rl=rlc.getRecipes();
            //((TextView) findViewById(R.id.showtest)).setText(foodlist.get(0));
            //((TextView) findViewById(R.id.showtest2)).setText(catlist.get(0));
            //((TextView) findViewById(R.id.showtest3)).setText(cuisinelist.get(0));

            final ArrayList<String> res = findTop(rl, foodlist,catlist,cuisinelist,Integer.parseInt(rank), reso);
            System.out.println("end search");
            if(res==null||res.size()==0){
                System.out.println("no recipe!!!!!!!!!!!");
                ((TextView) findViewById(R.id.bbb)).setText("no recipe found!");
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll.removeAllViews();
                LinearLayout lll = (LinearLayout) findViewById(R.id.layout1);
                lll.removeAllViews();
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
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout ll1 = (LinearLayout) findViewById(R.id.layout2);
                ll.removeAllViews();
                LinearLayout norecipe = (LinearLayout) findViewById(R.id.layout12);
                norecipe.removeAllViews();
            } else if(res.size() == 2) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                LinearLayout ll = (LinearLayout) findViewById(R.id.layout3);
                ll.removeAllViews();
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout norecipe = (LinearLayout) findViewById(R.id.layout12);
                norecipe.removeAllViews();
            } else if(res.size() == 3) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText(res.get(2).toString());
                LinearLayout ll2 = (LinearLayout) findViewById(R.id.layout4);
                ll2.removeAllViews();
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout norecipe = (LinearLayout) findViewById(R.id.layout12);
                norecipe.removeAllViews();
            } else if(res.size() == 4) {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText(res.get(2).toString());
                ((CheckBox)findViewById(R.id.check4)).setText(res.get(3).toString());
                LinearLayout ll3 = (LinearLayout) findViewById(R.id.layout5);
                ll3.removeAllViews();
                LinearLayout norecipe = (LinearLayout) findViewById(R.id.layout12);
                norecipe.removeAllViews();
            } else {
                ((CheckBox)findViewById(R.id.check1)).setText(res.get(0).toString());
                ((CheckBox)findViewById(R.id.check2)).setText(res.get(1).toString());
                ((CheckBox)findViewById(R.id.check3)).setText(res.get(2).toString());
                ((CheckBox)findViewById(R.id.check4)).setText(res.get(3).toString());
                ((CheckBox)findViewById(R.id.check5)).setText(res.get(4).toString());
                LinearLayout norecipe = (LinearLayout) findViewById(R.id.layout12);
                norecipe.removeAllViews();
            }
            if(res.size()<Integer.parseInt(rank)){
                ((TextView) findViewById(R.id.Error)).setText("Recipes containing such combination are fewer than you expected!");
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
    public static ArrayList<String> findTop(ArrayList<Recipe> rl,ArrayList<String> foodInput, ArrayList<String> type, ArrayList<String> cuisine, int top, Resources reso) throws JSONException, IOException  {
        HashMap<String, Integer> map = new HashMap<>();
        for(Recipe recipe:rl) {
            System.out.println(recipe.getCuisine());
            if(checkCuisine(cuisine,recipe.getCuisine().toLowerCase())) {
                ArrayList<String> ingredientsList = recipe.getIngredients();
                System.out.println("entered ingr list");
                if(checkContains(foodInput, ingredientsList)) {
                    System.out.println("checked contains ingr");
                    for(String ingredient:ingredientsList) {
                        if(!foodInput.contains(ingredient)) {
                            if(checkType(type, ingredient, reso)) {
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

    public static boolean checkType(ArrayList<String> typeList, String ingredient, Resources res) {
        if(typeList.contains("all")) {
            return true;
        }

        if(typeList.contains("carb")) {
            InputStream carbi = res.openRawResource(R.raw.carbs);
            Carb carb = new Carb(carbi);
            for(String c:carb.getCarbs()){
                if (ingredient.equals(c) || c.equals(ingredient)) {
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
                if (ingredient.equals(d) || d.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("fruit")) {
            InputStream fruiti=res.openRawResource(R.raw.fruits);
            Fruit fruit = new Fruit(fruiti);
            for(String f:fruit.getFruits()){
                if (ingredient.equals(f) || f.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("meat")) {
            InputStream meati=res.openRawResource(R.raw.meats);
            Meat meat = new Meat(meati);
            for(String m:meat.getMeats()){
                if (ingredient.equals(m) || m.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("oil")) {
            InputStream oili=res.openRawResource(R.raw.oils);
            Oil oil = new Oil(oili);
            for(String o:oil.getOils()){
                if (ingredient.equals(o) || o.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("other")) {
            InputStream otheri=res.openRawResource(R.raw.others);
            Other other = new Other(otheri);
            for(String o:other.getOthers()){
                if (ingredient.equals(o) || o.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("seafood")) {
            InputStream seafoodi=res.openRawResource(R.raw.seafoods);
            SeaFood seafood = new SeaFood(seafoodi);
            for(String s:seafood.getSeaFoods()){
                if (ingredient.equals(s) || s.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("seasoning")) {
            InputStream seasoningi=res.openRawResource(R.raw.seasonings);
            Seasoning seasoning = new Seasoning(seasoningi);
            for(String s:seasoning.getSeasonings()){
                if (ingredient.equals(s) || s.equals(ingredient)) {
                    return true;
                }
            }
        }
        if(typeList.contains("veggie")) {
            InputStream veggiei=res.openRawResource(R.raw.veggies);
            Veggie veggie = new Veggie(veggiei);
            for(String v:veggie.getVeggies()){
                if (ingredient.equals(v) || v.equals(ingredient)) {
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