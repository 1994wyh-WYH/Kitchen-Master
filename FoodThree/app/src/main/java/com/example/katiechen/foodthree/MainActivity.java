package com.example.katiechen.foodthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private BasicInfo basicInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicInfo = new BasicInfo();

        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        Button howtouse = findViewById(R.id.howtouse);
        howtouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Main11Activity.class);
                startActivity(intent2);
            }
        });

    }

}
