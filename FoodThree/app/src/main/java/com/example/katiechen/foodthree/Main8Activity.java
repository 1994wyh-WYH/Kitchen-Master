package com.example.katiechen.foodthree;

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
            System.out.println(orderby);
            ArrayList<FullRecipe> result = findFullRecipe(rs,ingredientsList,orderby);
            LinearLayout ll = (LinearLayout) findViewById(R.id.crappy_list);
            ll.removeAllViews();
            for(FullRecipe fc: result) {
                View view = getListItemView(fc);
                ll.addView(view);
            }
//            for (FullRecipe fc: result) {
//                System.out.println(fc.getTitle());
//                System.out.println(fc.getDate());
//                System.out.println(fc.getCalories());
//                System.out.println(fc.getFat());
//                System.out.println(fc.getCategories());
//                System.out.println(fc.getProtein());
//                System.out.println(fc.getIngredients());
//                System.out.println(fc.getRating());
//                System.out.println(fc.getDescription());
//                System.out.println("=======================================================");
//            }
        } catch (Exception e){
            //((TextView) findViewById(R.id.showrecipe)).setText(("trouble reading JSON"));
        }

    }

    @NonNull
    private View getListItemView(@NonNull FullRecipe r) {
        View view = getLayoutInflater().inflate(R.layout.content_main8, null);
        ((TextView)view.findViewById(R.id.title)).setText("Title: " + r.getTitle());
        ((TextView)view.findViewById(R.id.date)).setText("Date: "+r.getDate());
        ((TextView)view.findViewById(R.id.rating)).setText("Rating: " + r.getRating().toString());
        ((TextView)view.findViewById(R.id.Fat)).setText("Fat: " + r.getFat().toString());

        ((TextView)view.findViewById(R.id.Calories)).setText("Calories: " + r.getCalories().toString());

        ((TextView)view.findViewById(R.id.Protein)).setText("Protein: " + r.getProtein().toString());

        ((TextView)view.findViewById(R.id.ingredients)).setText("Ingredients: " + r.getIngredients().toString());

        if(r.getDescription()!=null && r.getDescription().length() > 0) {
            ((TextView)view.findViewById(R.id.description)).setText("Description: " + r.getDescription().toString());
        }
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
        System.out.println(orderby);
        if(orderby.equals("fat high to low")) {
            Collections.sort(result, new MyFatDESCComparator());
        } else if (orderby.equals("fat low to high")) {
            Collections.sort(result, new MyFatASCComparator());
        } else if (orderby.equals("rating high to low")) {
            Collections.sort(result, new MyRatingDESCComparator());
        } else if (orderby.equals("rating low to high")) {
            Collections.sort(result, new MyRatingASCComparator());
        } else if (orderby.equals("cal high to low")) {
            Collections.sort(result, new MyCalDESCComparator());
        } else if (orderby.equals("cal low to high")) {
            Collections.sort(result, new MyCalASCComparator());
        } else if (orderby.equals("protein high to low")) {
            Collections.sort(result, new MyProteinDESCComparator());
        } else {
            System.out.println("else");
            Collections.sort(result, new MyProteinASCComparator());
        }
        return result;
    }

    static class MyFatDESCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getFat() - r2.getFat()) == 0) {
                return 0;
            } else {
                if((r1.getFat() - r2.getFat()) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    static class MyFatASCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getFat() - r2.getFat()) == 0) {
                return 0;
            } else {
                if((r1.getFat() - r2.getFat()) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    static class MyRatingASCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getRating() - r2.getRating()) == 0) {
                return 0;
            } else {
                if((r1.getRating() - r2.getRating()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    static class MyRatingDESCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getRating() - r2.getRating()) == 0) {
                return 0;
            }
            else {
                if((r1.getRating() - r2.getRating()) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    static class MyCalDESCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getCalories() - r2.getCalories()) == 0) {
                return 0;
            }
            else {
                if((r1.getCalories()-r2.getCalories()) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    static class MyCalASCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getCalories() - r2.getCalories()) == 0) {
                return 0;
            }
            else {
                if((r1.getCalories()-r2.getCalories()) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    static class MyProteinDESCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getProtein() - r2.getProtein()) == 0) {
                return 0;
            }
            else {
                if((r1.getProtein() - r2.getProtein()) < 0 ) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
    static class MyProteinASCComparator implements Comparator<FullRecipe> {
        @Override
        public int compare(FullRecipe r1, FullRecipe r2) {
            if ((r1.getProtein() - r2.getProtein()) == 0) {
                return 0;
            }
            else {
                if((r1.getProtein() - r2.getProtein()) < 0 ) {
                    return -1;
                } else {
                    return 1;
                }
            }
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
