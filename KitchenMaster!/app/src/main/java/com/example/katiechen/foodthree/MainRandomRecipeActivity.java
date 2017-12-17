package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainRandomRecipeActivity extends AppCompatActivity {
    public ArrayList<String> ingredientsList;
    public FullRecipe res;
    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;
    public String rank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ingredientsList = getIntent().getStringArrayListExtra(MainIngreOutputActivity.INGREDIENTS);
        final InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            ArrayList<String> inputCopy = new ArrayList<>();
            for (String temp : ingredientsList) {
                inputCopy.add(temp);
            }
            res = findRamdonRecipe(rs, inputCopy);
            String title = "";
            for(String ing: ingredientsList) {
                title = title + ing + " ";
            }
            if (res == null) {
                ((TextView) findViewById(R.id.title)).setText("Ooops!\n Cannot find random recipes based on your input ingredient!\n Please go back to Home page and input again!");
            } else {
                ((TextView) findViewById(R.id.title)).setText("TITLE: " + title.toUpperCase() + "RECIPE");
                ((TextView) findViewById(R.id.ingredients)).setText("Ingredients: " + res.getIngredients().toString());
                ((TextView) findViewById(R.id.direction)).setText("Directions: " + res.getDirections().toString());
            }
        } catch (Exception e) {
            ((TextView) findViewById(R.id.title)).setText("Ooops!\n Cannot find random recipes based on your input ingredient!\n Please go back to Home page and input again!");
        }

        //if click to change, it will change to a new random recipe
        Button startButton = findViewById(R.id.change);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainRandomRecipeActivity.this, MainRandomRecipeActivity.class);
                putIntentData(intent);
                startActivity(intent);
            }
        });

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainRandomRecipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * @param rs          full recipe list
     * @param ingredients ingredients user input and select before
     * @return a random recipe whose type is FullRecipe only containing ingredients and direction
     */
    public static FullRecipe findRamdonRecipe(ArrayList<FullRecipe> rs, ArrayList<String> ingredients) {
        Random rand = new Random();
        ArrayList<String> randomI = new ArrayList<>();
        ArrayList<String> randomD = new ArrayList<>();
        ArrayList<String> toRemove = new ArrayList<>();
        while (ingredients.size() > 0) {
            int s = rand.nextInt(rs.size());
            for (int i = s; i < rs.size(); i++) {
                FullRecipe fullrecipe = rs.get(i);
                ArrayList<String> foodlist = fullrecipe.getIngredients();
                ArrayList<String> dirlist = fullrecipe.getDirections();
                if (foodlist != null && dirlist != null && dirlist.size() != 0) {
                    for (String ingredient : ingredients) {
                        if (getIngredient(foodlist, ingredient) != null && getIngredient(dirlist, ingredient) != null) {
                            randomI.add(getIngredient(foodlist, ingredient));
                            if (!randomD.contains(getIngredient(dirlist, ingredient))) {
                                randomD.add(getIngredient(dirlist, ingredient));
                            }
                            toRemove.add(ingredient);
                        }
                    }
                }
                for (String remove : toRemove) {
                    ingredients.remove(remove);
                }
                toRemove.clear();
            }

        }
        FullRecipe randomF = new FullRecipe(randomD, 0.0, null, null, 0.0, null, 0.0, 0.0, null, randomI, 0.0);
        return randomF;
    }

    /**
     * Helper Function to get ingredient from foodlist if the ingredient contains the ingredient user input or select before
     *
     * @param foodlist   full food list from the one full recipe
     * @param ingredient user input and select before
     * @return the food list from the one full recipe
     */
    public static String getIngredient(ArrayList<String> foodlist, String ingredient) {
        for (String ingre : foodlist) {
            if (((ingre.toString()).contains(ingredient))) {
                return ingre;
            }
        }
        return null;
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

    /**
     * Put data into intent
     *
     * @param intent intent connect to next activity
     */
    public void putIntentData(Intent intent) {
        intent.putExtra(MainIngreInputActivity.FOODLIST, foodlist);
        intent.putExtra(MainCategoryActivity.CATLIST, catlist);
        intent.putExtra(MainCuisineActivity.CUISINE, cuisinelist);
        intent.putExtra(MainRankActivity.RANK, rank);
        intent.putExtra(MainIngreOutputActivity.INGREDIENTS, ingredientsList);
    }

}
