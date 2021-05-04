package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameCityGame extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_city_game);

        Button buttonNormalGame = (Button)findViewById(R.id.buttonNormalGame);

        buttonNormalGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NameCityGame.this, NormalGameActivity.class));
            }

        });
    }


    public void buttonHome(View v){

        //Aktivite Geçme Kodu
    }
}