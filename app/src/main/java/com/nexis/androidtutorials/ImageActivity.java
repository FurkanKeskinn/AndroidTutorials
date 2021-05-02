package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView imgTest = (ImageView)findViewById(R.id.imgaeView);

        //ImageView setBackgroundColor ile Arkaplan Rengi Değiştirme
        //imgTest.setBackgroundColor(Color.RED);

        //ImageView setBackgroundColor ile Arkaplan Resmini Değiştirme
        //imgTest.setBackgroundResource(R.drawable.jerry);

        //ImageView setBackgroundColor ile Arkaplan Resmini Değiştirme
        //Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.jerry);

        //ImageView setBackgroundColor ile Arkaplan Resmini Değiştirme
        //imgTest.setRotation((133.5f));


    }
}




