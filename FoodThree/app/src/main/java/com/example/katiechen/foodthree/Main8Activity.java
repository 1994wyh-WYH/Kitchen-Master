package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Main8Activity extends AppCompatActivity {
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

        foodlist = getIntent().getStringArrayListExtra(MainIngreInputActivity.FOODLIST);
        catlist = getIntent().getStringArrayListExtra(MainCategoryActivity.CATLIST);
        cuisinelist = getIntent().getStringArrayListExtra(MainCuisineActivity.CUISINE);
        rank = getIntent().getStringExtra(MainRankActivity.RANK);
        ingredientsList = getIntent().getStringArrayListExtra(MainIngreOutputActivity.INGREDIENTS);
        final InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            res = findRamdonRecipe(rs,ingredientsList);
            if(res == null) {
                ((TextView) findViewById(R.id.title)).setText("Ooops!\n Cannot find Random Recipe based on your input ingredient!\n Please go back to Home page and input again!");
            } else {
                ((TextView) findViewById(R.id.title)).setText(res.getTitle());
                ((TextView) findViewById(R.id.ingredients)).setText(res.getIngredients().toString());
            }
        } catch (Exception e){
            //((TextView) findViewById(R.id.showrecipe)).setText(("trouble reading JSON"));
        }
        Button startButton = findViewById(R.id.change);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main8Activity.this, Main8Activity.class);
                putIntentData(intent);
                startActivity(intent);
            }
        });

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main8Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public FullRecipe findRamdonRecipe(ArrayList<FullRecipe> rs, ArrayList<String> ingredients) {
        Random rand = new Random();
        int s = rand.nextInt(rs.size());
        ArrayList<String> randomI = new ArrayList<>();
        ArrayList<String> randomD = new ArrayList<>();
        while (randomI.size()==0||randomD.size()==0){
            for (int i = s; i < rs.size(); i++) {
                FullRecipe fullrecipe = rs.get(i);
                ArrayList<String> foodlist = fullrecipe.getIngredients();
                if (foodlist != null) {
                    for (String ingredient : ingredients) {
                        if (getIngredient(foodlist, ingredient) != null) {
                            randomI.add(getIngredient(foodlist, ingredient));
                            int select = rand.nextInt(fullrecipe.getDirections().size());
                            randomD.add(fullrecipe.getDirections().get(select));
                        }
                    }
                }
            }
        s--;
    }
        FullRecipe randomF=new FullRecipe(randomD, 0.0, null, null, 0.0, null, 0.0, 0.0, null, randomI, 0.0);
        return randomF;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void putIntentData(Intent intent) {
        intent.putExtra(MainIngreInputActivity.FOODLIST, foodlist);
        intent.putExtra(MainCategoryActivity.CATLIST, catlist);
        intent.putExtra(MainCuisineActivity.CUISINE, cuisinelist);
        intent.putExtra(MainRankActivity.RANK, rank);
        intent.putExtra(MainIngreOutputActivity.INGREDIENTS, ingredientsList);
    }

    public static String getIngredient(ArrayList<String> foodlist, String ingredient) {
        for(String ingre: foodlist) {
            if(!ingre.contains(ingredient)) {
                return ingre;
            }
        }
        return null;
    }

}
