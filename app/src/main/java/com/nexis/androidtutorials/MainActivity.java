package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonCalculate = (Button)findViewById(R.id.button_calculate);
        Button estimatingNumbers = (Button)findViewById(R.id.estimating_numbers);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, CalculateActivity.class));
            }

        });
        estimatingNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z) {
                startActivity(new Intent(MainActivity.this, EstimatingNumbers.class));
            }
        });

    }
}