package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {
    public ArrayList<String> ingredientsList;
    public static final String ORDERBY = "ORDERBY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ingredientsList = getIntent().getStringArrayListExtra(Main6Activity.INGREDIENTS);

        Button startButton = findViewById(R.id.one);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "fat low to high");
                startActivity(intent);
            }
        });

        Button startButton2 = findViewById(R.id.two);
        startButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "fat high to low");
                startActivity(intent);
            }
        });

        Button startButton3 = findViewById(R.id.three);
        startButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "rating low to high");
                startActivity(intent);
            }
        });

        Button startButton4 = findViewById(R.id.four);
        startButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "rating high to low");
                startActivity(intent);
            }
        });

        Button startButton5 = findViewById(R.id.five);
        startButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "cal low to high");
                startActivity(intent);
            }
        });
        Button startButton6 = findViewById(R.id.six);
        startButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "cal high to low");
                startActivity(intent);
            }
        });
        Button startButton7 = findViewById(R.id.seven);
        startButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "protein low to high");
                startActivity(intent);
            }
        });
        Button startButton8 = findViewById(R.id.eight);
        startButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main7Activity.this, Main12Activity.class);
                setData(intent, "protein high to low");
                startActivity(intent);
            }
        });
    }

    public void setData(Intent intent, String orderby) {
        intent.putExtra(Main6Activity.INGREDIENTS, ingredientsList);
        intent.putExtra(ORDERBY, orderby);
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
