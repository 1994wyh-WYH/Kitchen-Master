/**package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main8Activity extends AppCompatActivity {
    public ArrayList<String> ingredientsList;
    public String orderby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ingredientsList = getIntent().getStringArrayListExtra(Main6Activity.INGREDIENTS);
        orderby = getIntent().getStringExtra(Main7Activity.ORDERBY);
        InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            ArrayList<FullRecipe> result = findFullRecipe(rs,ingredientsList,orderby);
            LinearLayout ll = (LinearLayout) findViewById(R.id.crappy_list);
            ll.removeAllViews();
            for(FullRecipe fc: result) {
                View view = getListItemView(fc);
                ll.addView(view);
            }
            for (FullRecipe fc: result) {
                System.out.println(fc.getTitle());
                System.out.println(fc.getDate());
                System.out.println(fc.getCalories());
                System.out.println(fc.getFat());
                System.out.println(fc.getCategories());
                System.out.println(fc.getProtein());
                System.out.println(fc.getIngredients());
                System.out.println(fc.getRating());
                System.out.println(fc.getDescription());
                System.out.println("=======================================================");
            }
        } catch (Exception e){
            ((TextView) findViewById(R.id.showrecipe)).setText(("trouble reading JSON"));
        }

    }

    @NonNull
    private View getListItemView(@NonNull FullRecipe r) {
        View view = getLayoutInflater().inflate(R.layout.content_main8, null);
        ((TextView)view.findViewById(R.id.title)).setText(r.getTitle());
        //((TextView)view.findViewById(R.id.date)).setText(r.getDate());
        //((TextView)view.findViewById(R.id.rating)).setText(r.getRating().toString());
        ((TextView)view.findViewById(R.id.ingredients)).setText(r.getIngredients().toString());
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static ArrayList<FullRecipe> findFullRecipe(ArrayList<FullRecipe> rs, ArrayList<String> ingredients, String orderby) {
        ArrayList<FullRecipe> result = new ArrayList<>();
        for(FullRecipe recipe:rs) {
            ArrayList<String> foodlist = recipe.getIngredients();
            if(foodlist!=null) {
                String ingredientString = foodlist.toString();
                if(checkIngredientInside(ingredientString, ingredients)) {
                    result.add(recipe);
                }
            }
        }
        if(orderby == "fat high to low") {
            Collections.sort(result, new MyFatDESCComparator());
        } else if (orderby == "fat low to high") {
            Collections.sort(result, new MyFatASCComparator());
        } else if (orderby == "rating high to low") {
            Collections.sort(result, new MyRatingDESCComparator());
        } else if (orderby == "rating low to high") {
            Collections.sort(result, new MyRatingASCComparator());
        } else if (orderby == "cal high to low") {
            Collections.sort(result, new MyCalDESCComparator());
        } else if (orderby == "cal low to high") {
            Collections.sort(result, new MyCalDESCComparator());
        } else if (orderby == "protein high to low") {
            Collections.sort(result, new MyProteinDESCComparator());
        } else {
            Collections.sort(result, new MyProteinASCComparator());
        }
        return result;
    }

    static class MyFatDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getFat() == r2.getFat()) {
                return 0;
            }
            return r1.getFat() < r2.getFat() ? 1 : -1;
        }
    }
    static class MyFatASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getFat() == r2.getFat()) {
                return 0;
            }
            return r1.getFat() > r2.getFat() ? 1 : -1;
        }
    }
    static class MyRatingASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getRating() == r2.getRating()) {
                return 0;
            }
            return r1.getRating() > r2.getRating() ? 1 : -1;
        }
    }
    static class MyRatingDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getRating() == r2.getRating()) {
                return 0;
            }
            return r1.getRating() < r2.getRating() ? 1 : -1;
        }
    }
    static class MyCalDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getCalories() == r2.getCalories()) {
                return 0;
            }
            return r1.getCalories() < r2.getCalories() ? 1 : -1;
        }
    }
    static class MyCalASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getCalories() == r2.getCalories()) {
                return 0;
            }
            return r1.getCalories() > r2.getCalories() ? 1 : -1;
        }
    }
    static class MyProteinDESCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getProtein() == r2.getProtein()) {
                return 0;
            }
            return r1.getProtein() < r2.getProtein() ? 1 : -1;
        }
    }
    static class MyProteinASCComparator implements Comparator<FullRecipe> {
        public int compare(FullRecipe r1, FullRecipe r2) {
            if (r1.getProtein() == r2.getProtein()) {
                return 0;
            }
            return r1.getProtein() < r2.getProtein() ? 1 : -1;
        }
    }

    public static boolean checkIngredientInside(String ingredientString, ArrayList<String> ingredients) {
        for(String ingre: ingredients) {
            Pattern pattern = Pattern.compile(ingre);
            Matcher match = (pattern).matcher(ingredientString);
            if(!match.find()) {
                return false;
            }
        }
        return true;
    }
}
**/