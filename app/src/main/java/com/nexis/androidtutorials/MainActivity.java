package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalculate = (Button)findViewById(R.id.button_calculate);
        Button estimatingNumbers = (Button)findViewById(R.id.estimating_numbers);
        Button imageActivity = (Button)findViewById(R.id.imageTest);
        Button signUpPage = (Button)findViewById(R.id.signUppage);
        Button buttonAndBar = (Button)findViewById(R.id.buttonAndBar);
        Button randomOperation = (Button)findViewById(R.id.randomOperation);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, CalculateActivity.class));
            }

        });

        estimatingNumbers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EstimatingNumbers.class));
            }
        });

        imageActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

        signUpPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpPage.class));
            }
        });

        buttonAndBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ButtonAndBarActivity.class));
            }
        });

        randomOperation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RandomOperationActivity.class));
            }
        });
    }
}