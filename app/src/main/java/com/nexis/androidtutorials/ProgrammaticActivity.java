package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class ProgrammaticActivity extends AppCompatActivity {

    private LinearLayout lineer;
    private Button button;
    private LinearLayout.LayoutParams params;

    private void init(){

        lineer = new LinearLayout(this);
        lineer.setOrientation(LinearLayout.VERTICAL);

        for(int i = 0; i<3; i++){
            button = new Button(this);
            button.setText("Button " + (i + 1));
            button.setTextSize(21);
            params = new LinearLayout.LayoutParams(350,150);
            params.topMargin = 15;
            params.leftMargin = 5;
            button.setLayoutParams(params);

            lineer.addView(button);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(lineer);
    }
}