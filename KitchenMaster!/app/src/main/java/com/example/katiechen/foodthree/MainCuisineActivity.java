package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainCuisineActivity extends AppCompatActivity {

    public static final String CUISINE = "cuisine";
    public ArrayList<String> foodlist;
    public ArrayList<String> catlist;
    public ArrayList<String> cuisinelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kitchen Master");

        foodlist = getIntent().getStringArrayListExtra(MainIngreInputActivity.FOODLIST);
        catlist = getIntent().getStringArrayListExtra(MainCategoryActivity.CATLIST);

        Button startButton = findViewById(R.id.next3);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainCuisineActivity.this, MainRankActivity.class);
                setData(intent);
                if(cuisinelist.size()>=1) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainCuisineActivity.this,"Please Select at Least One Cuisine!",Toast.LENGTH_LONG).show();
                }
            }
        });
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
     * Put cuisine list into intent
     *
     * @param intent intent connect to next activity
     */
    public void setData(Intent intent) {
        cuisinelist = new ArrayList<>();
        CheckBox check1 = findViewById(R.id.Chinese);
        if (check1.isChecked()) {
            cuisinelist.add("chinese");
        }
        CheckBox check2 = findViewById(R.id.Indian);
        if (check2.isChecked()) {
            cuisinelist.add("indian");
        }
        CheckBox check3 = findViewById(R.id.cajun_creole);
        if (check3.isChecked()) {
            cuisinelist.add("cajun_creole");
        }
        CheckBox check4 = findViewById(R.id.Mexican);
        if (check4.isChecked()) {
            cuisinelist.add("mexican");
        }
        CheckBox check5 = findViewById(R.id.Vietnamese);
        if (check5.isChecked()) {
            cuisinelist.add("vietnamese");
        }
        CheckBox check6 = findViewById(R.id.Italian);
        if (check6.isChecked()) {
            cuisinelist.add("italian");
        }
        CheckBox check7 = findViewById(R.id.Brazilian);
        if (check7.isChecked()) {
            cuisinelist.add("brazilian");
        }
        CheckBox check8 = findViewById(R.id.British);
        if (check8.isChecked()) {
            cuisinelist.add("british");
        }
        CheckBox check9 = findViewById(R.id.Korean);
        if (check9.isChecked()) {
            cuisinelist.add("korean");
        }
        CheckBox check10 = findViewById(R.id.Moroccan);
        if (check10.isChecked()) {
            cuisinelist.add("moroccan");
        }
        CheckBox check11 = findViewById(R.id.Jamaican);
        if (check11.isChecked()) {
            cuisinelist.add("jamaican");
        }
        CheckBox check12 = findViewById(R.id.Greek);
        if (check12.isChecked()) {
            cuisinelist.add("greek");
        }
        CheckBox check13 = findViewById(R.id.Filipino);
        if (check13.isChecked()) {
            cuisinelist.add("filipino");
        }
        CheckBox check14 = findViewById(R.id.Thai);
        if (check14.isChecked()) {
            cuisinelist.add("thai");
        }
        CheckBox check15 = findViewById(R.id.French);
        if (check15.isChecked()) {
            cuisinelist.add("french");
        }
        CheckBox check16 = findViewById(R.id.Spanish);
        if (check16.isChecked()) {
            cuisinelist.add("spanish");
        }
        CheckBox check17 = findViewById(R.id.Irish);
        if (check17.isChecked()) {
            cuisinelist.add("irish");
        }
        CheckBox check18 = findViewById(R.id.Southern_us);
        if (check18.isChecked()) {
            cuisinelist.add("southern us");
        }
        CheckBox check19 = findViewById(R.id.all);
        if (check19.isChecked()) {
            cuisinelist.add("all");
        }
        CheckBox check20 = findViewById(R.id.Japanese);
        if (check20.isChecked()) {
            cuisinelist.add("japanese");
        }
        CheckBox check21 = findViewById(R.id.Rassian);
        if (check21.isChecked()) {
            cuisinelist.add("russian");
        }
        intent.putExtra(MainIngreInputActivity.FOODLIST, foodlist);
        intent.putExtra(MainCategoryActivity.CATLIST, catlist);
        intent.putExtra(CUISINE, cuisinelist);
    }

}
