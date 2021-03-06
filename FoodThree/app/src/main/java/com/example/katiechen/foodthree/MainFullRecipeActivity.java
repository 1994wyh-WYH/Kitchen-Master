package com.example.katiechen.foodthree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainFullRecipeActivity extends AppCompatActivity {
    public ArrayList<String> ingredientsList;
    public String orderby;
    public ArrayList<FullRecipe> result;
    public static final String RESULT ="RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ingredientsList = getIntent().getStringArrayListExtra(MainIngreOutputActivity.INGREDIENTS);
        orderby = getIntent().getStringExtra(MainRecipeRankActivity.ORDERBY);
        InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        try {
            FullRecipeList fr = new FullRecipeList(in);
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
            System.out.println(orderby);
            System.out.println(ingredientsList.toString());
            result = findFullRecipe(rs,ingredientsList,orderby);
            BlankFragment.res = result;
        } catch (Exception e){
            //((TextView) findViewById(R.id.showrecipe)).setText(("trouble reading JSON"));
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new NumberPagerAdapter(getSupportFragmentManager()));
    }

    private class NumberPagerAdapter extends FragmentPagerAdapter {
        public NumberPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return BlankFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            System.out.println("main result size: " + result.size());
            if(result.size() == 0) {
                return 1;
            }
            return result.size();
        }
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
        if(result.size() == 0) {
            return result;
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
