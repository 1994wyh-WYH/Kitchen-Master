package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    public static final String CUISINE = "cuisine";
    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodlist = getIntent().getStringArrayListExtra(Main2Activity.FOODLIST);
        catlist = getIntent().getStringArrayListExtra(Main3Activity.CATLIST);

        Button startButton = findViewById(R.id.next3);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
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
        cuisinelist = new ArrayList<>();
        CheckBox check1 = findViewById(R.id.chinese);
        if (check1.isChecked()) {
            cuisinelist.add("chinese");
        }
        CheckBox check2 = findViewById(R.id.american);
        if (check2.isChecked()) {
            cuisinelist.add("american");
        }
        CheckBox check3 = findViewById(R.id.japan);
        if (check3.isChecked()) {
            cuisinelist.add("japanese");
        }
        CheckBox check4 = findViewById(R.id.mexican);
        if (check4.isChecked()) {
            cuisinelist.add("mexican");
        }
        CheckBox check5 = findViewById(R.id.korean);
        if (check5.isChecked()) {
            cuisinelist.add("korean");
        }
        CheckBox check6 = findViewById(R.id.italian);
        if (check6.isChecked()) {
            cuisinelist.add("italian");
        }
        CheckBox check7 = findViewById(R.id.all);
        if (check7.isChecked()) {
            cuisinelist.add("all");
        }
        intent.putExtra(Main2Activity.FOODLIST, foodlist);
        intent.putExtra(Main3Activity.CATLIST, catlist);
        intent.putExtra(CUISINE, cuisinelist);
    }

}
