package com.example.katiechen.foodthree;

import android.content.res.Resources;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Main6Activity extends AppCompatActivity {

    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;
    public String rank;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodlist = getIntent().getStringArrayListExtra(Main2Activity.FOODLIST);
        ((TextView) findViewById(R.id.showfood)).setText(foodlist.toString());

        catlist = getIntent().getStringArrayListExtra(Main3Activity.CATLIST);
        ((TextView) findViewById(R.id.showcat)).setText(catlist.toString());

        cuisinelist = getIntent().getStringArrayListExtra(Main4Activity.CUISINE);
        ((TextView) findViewById(R.id.showcuisine)).setText(cuisinelist.toString());

        rank = getIntent().getStringExtra(Main5Activity.RANK);
        ((TextView) findViewById(R.id.rank)).setText(rank.toString());

        //((TextView) findViewById(R.id.showtest)).setText("Hello");

        try{
            TestClass tc = new TestClass();
            ((TextView) findViewById(R.id.showtest)).setText(tc.getText());
        } catch(Exception e){

        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        InputStream in = getResources().openRawResource(R.raw.full_format_recipes);
        try {

            FullRecipeList fr = new FullRecipeList(in);
            ((TextView) findViewById(R.id.showtest)).setText("Hello1");
            ArrayList<FullRecipe> rs = fr.getFullRecipes();
//		if(rs.isEmpty())
//			System.out.println(1);
            System.out.println(rs.size());
            ((TextView) findViewById(R.id.showrecipe)).setText(Integer.toString(rs.size()));
        } catch (Exception e){
            ((TextView) findViewById(R.id.showrecipe)).setText(("trouble reading JSON"));
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




}
