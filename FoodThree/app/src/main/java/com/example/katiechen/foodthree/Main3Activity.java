package com.example.katiechen.foodthree;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public static final String CATLIST = "Cat list";

    private static final int FOOD_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodlist = getIntent().getStringArrayListExtra(Main2Activity.FOODLIST);

        Button startButton = findViewById(R.id.next2);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                setData(intent);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setData(Intent intent) {
        catlist = new ArrayList<>();
        CheckBox check1 = findViewById(R.id.veggie);
        if (check1.isChecked()) {
            catlist.add("veggie");
        }
        CheckBox check2 = findViewById(R.id.meat);
        if (check2.isChecked()) {
            catlist.add("meat");
        }
        CheckBox check3 = findViewById(R.id.fruit);
        if (check3.isChecked()) {
            catlist.add("fruit");
        }
        CheckBox check4 = findViewById(R.id.seafood);
        if (check4.isChecked()) {
            catlist.add("seafood");
        }
        CheckBox check5 = findViewById(R.id.other);
        if (check5.isChecked()) {
            catlist.add("other");
        }
        CheckBox check6 = findViewById(R.id.all);
        if (check6.isChecked()) {
            catlist.add("all");
        }
        CheckBox check7 = findViewById(R.id.carb);
        if (check7.isChecked()) {
            catlist.add("carb");
        }
        CheckBox check8 = findViewById(R.id.oil);
        if (check8.isChecked()) {
            catlist.add("oil");
        }
        CheckBox check9 = findViewById(R.id.seasoning);
        if (check9.isChecked()) {
            catlist.add("seasoning");
        }
        CheckBox check10 = findViewById(R.id.dairy);
        if (check10.isChecked()) {
            catlist.add("dairy");
        }
        intent.putExtra(CATLIST, catlist);
        intent.putExtra(Main2Activity.FOODLIST, foodlist);
    }
}