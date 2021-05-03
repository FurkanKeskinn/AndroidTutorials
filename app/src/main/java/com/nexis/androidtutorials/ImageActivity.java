package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;

public class ImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView imgTest = (ImageView)findViewById(R.id.imgaeView);
        CheckBox checkTest = (CheckBox)findViewById(R.id.checkBoxTest);
        RadioButton radioTest1 = (RadioButton)findViewById(R.id.radioMan);
        RadioButton radioTest2 = (RadioButton)findViewById(R.id.radioWoman);
        Switch switchTest = (Switch)findViewById(R.id.switchTest);

        //---------------ImageView Özellikleri---------------
        //ImageView setBackgroundColor ile Arkaplan Rengi Değiştirme
        //imgTest.setBackgroundColor(Color.RED);

        //ImageView setBackgroundColor ile Arkaplan Resmini Değiştirme
        //imgTest.setBackgroundResource(R.drawable.jerry);

        //ImageView setBackgroundColor ile Arkaplan Resmini Değiştirme
        //Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.jerry);

        //ImageView setBackgroundColor ile Arkaplan Resmini Değiştirme
        //imgTest.setRotation((133.5f));



        //---------------Checkbox Özellikleri---------------

        //Checkbox setChecked Özelliği
        //checkTest.setChecked(true);

        //Checkbox setText Özelliği
        //checkTest.setText("Test");


        //Checkbox setOnCheckedChangeListener Özelliği
        /*checkTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    System.out.println("Toplam = " + (5+2));
                else
                    System.out.println("toplam İşleme Kapalı");
            }
        });*/


        //---------------RadioButton Özellikleri---------------

        /*radioTest1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    System.out.println("Cinsiyet Erkek");

            }
        });
        radioTest2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    System.out.println("Cinsiyet Kadın");
            }
        });*/


        //---------------Switch Özellikleri---------------

        /*switchTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    System.out.println("Müzik Açık");
                else
                    System.out.println("Müzik Kapalı");
            }
        });*/


    }
}




