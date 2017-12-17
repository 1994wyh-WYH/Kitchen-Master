package com.example.katiechen.foodthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

public class MainIngreInputActivity extends AppCompatActivity {

    //In this activity, user is asked to input three ingredient
    //user's input ingredient will be stored in foodlist
    //Because we need to pass foodlist in to next activity(in the later activity, we need to use it)
    //Passing data also need to store in a Intent, and data is stored by a key, FOODLIST is the key of data
    private ArrayList<String> foodlist;
    public static final String FOODLIST = "food list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Show back to previous activity buttion
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //if next buttion is clicked, go to next activity
        Button startButton = findViewById(R.id.next);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainIngreInputActivity.this, MainCategoryActivity.class);
                setData(intent);
                if(foodlist.size()>=1) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainIngreInputActivity.this,"Please Enter at Lease One Ingredient!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setData(Intent intent) {
        foodlist = new ArrayList<>();
        if(((EditText) findViewById(R.id.food1)).getText().toString().length()>0) {
            foodlist.add(((EditText) findViewById(R.id.food1)).getText().toString().toLowerCase());
        }
        if(((EditText) findViewById(R.id.food2)).getText().toString().length()>0) {
            foodlist.add(((EditText) findViewById(R.id.food2)).getText().toString().toLowerCase());
        }
        if(((EditText) findViewById(R.id.food3)).getText().toString().length()>0) {
            foodlist.add(((EditText) findViewById(R.id.food3)).getText().toString().toLowerCase());
        }
        intent.putExtra(FOODLIST, foodlist);
    }

}
