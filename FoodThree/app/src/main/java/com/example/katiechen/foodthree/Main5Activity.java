package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {

    public static final String RANK = "rank";
    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;
    public String rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodlist = getIntent().getStringArrayListExtra(Main2Activity.FOODLIST);
        catlist = getIntent().getStringArrayListExtra(Main3Activity.CATLIST);
        cuisinelist = getIntent().getStringArrayListExtra(Main4Activity.CUISINE);

        Button startButton = findViewById(R.id.one);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                setData(intent, "1");
                startActivity(intent);
            }
        });

        Button startButton2 = findViewById(R.id.two);
        startButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                setData(intent, "2");
                startActivity(intent);
            }
        });

        Button startButton3 = findViewById(R.id.three);
        startButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                setData(intent, "3");
                startActivity(intent);
            }
        });

        Button startButton4 = findViewById(R.id.four);
        startButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                setData(intent, "4");
                startActivity(intent);
            }
        });

        Button startButton5 = findViewById(R.id.five);
        startButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
                setData(intent, "5");
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

    public void setData(Intent intent, String rank) {
        intent.putExtra(Main2Activity.FOODLIST, foodlist);
        intent.putExtra(Main3Activity.CATLIST, catlist);
        intent.putExtra(Main4Activity.CUISINE, cuisinelist);
        intent.putExtra(RANK, rank);
    }

}
