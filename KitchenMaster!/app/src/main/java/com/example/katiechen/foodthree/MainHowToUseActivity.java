package com.example.katiechen.foodthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainHowToUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //if clicked, go to how to use activity
        Button gotouse = findViewById(R.id.gotouse);
        gotouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainHowToUseActivity.this, MainIngreInputActivity.class);
                startActivity(intent2);
            }
        });
    }

    /**
     * Android studio API method, used to get back to previous activity
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
}
