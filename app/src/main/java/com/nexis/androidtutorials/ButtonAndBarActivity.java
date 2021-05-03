package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ButtonAndBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_and_bar);

        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        ImageView imageView = (ImageView)findViewById(R.id.imageToggle);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        TextView textSeekBar = (TextView)findViewById(R.id.textSeekBar);



        //-------ToggleButton Kullanımı ve Özellikleri-----

       /* toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    imageView.setVisibility(View.VISIBLE);
                else
                    imageView.setVisibility(View.INVISIBLE);
            }
        });*/

        /*toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = ((ToggleButton)v).isChecked();

                if(b)
                    imageView.setVisibility(View.VISIBLE);
                else
                    imageView.setVisibility(View.INVISIBLE);
            }
        });*/

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textSeekBar.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                System.out.println("SeekBar Hareket Edebilir.");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("SeekBar Durdu.");

            }
        });
    }
}