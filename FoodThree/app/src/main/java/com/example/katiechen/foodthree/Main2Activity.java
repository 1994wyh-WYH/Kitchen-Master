package com.example.katiechen.foodthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import com.example.katiechen.foodthree.Model.BasicInfo;


import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<String> foodlist;
    public static final String FOODLIST = "food list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button startButton = findViewById(R.id.next);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
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

    private void setData(Intent intent) {
        foodlist = new ArrayList<>();
        foodlist.add(((EditText) findViewById(R.id.food1)).getText().toString());
        foodlist.add(((EditText) findViewById(R.id.food2)).getText().toString());
        foodlist.add(((EditText) findViewById(R.id.food3)).getText().toString());
        intent.putExtra(FOODLIST, foodlist);
    }

}
