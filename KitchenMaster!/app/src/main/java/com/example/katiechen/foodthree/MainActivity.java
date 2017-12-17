package com.example.katiechen.foodthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show the activity_main page, which is in layout file in resource file. R means res.
        setContentView(R.layout.activity_main);


        //Find the button in the corresponding layout which id is called start. if user onclick this buttion
        //it will automatically run the setOnClickListerner method
        //Intent is a collection between one activity to another activity.
        //If the start button is onclick, it will start the activity which intent connect from current activity to.
        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainIngreInputActivity.class);
                startActivity(intent);
            }
        });

        //If the button called howtouse is clicked, it will start the MainHowToUseAvtivity activity
        Button howtouse = findViewById(R.id.howtouse);
        howtouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, MainHowToUseActivity.class);
                startActivity(intent2);
            }
        });

    }

}
