package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Random;

public class EstimatingNumbers extends AppCompatActivity {
    private TextView remain, info;
    private EditText enteredNumber;
    private String gelenDeger;
    private int kalanHak = 3, randomsayi;
    private Random rndNumber;
    private boolean tahminDogrumu = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_estimating_numbers);

        remain = (TextView) findViewById(R.id.textResidual);
        info = (TextView) findViewById(R.id.textScreen);
        enteredNumber = (EditText) findViewById(R.id.textNumber);

        rndNumber = new Random();
        randomsayi = rndNumber.nextInt(5);
        System.out.println("Random Sayı = " + randomsayi);

    }

    public void tahmin(View v) {

        gelenDeger = enteredNumber.getText().toString();

        if (!TextUtils.isEmpty(gelenDeger)) {

            if (kalanHak > 0) {

                if (gelenDeger.equals(String.valueOf(randomsayi))) {

                    sonucGoster("Tebrikle Doğru Tahminde Bulundunuz.");
                    tahminDogrumu = true;
                } else {
                    info.setText("Yanlış Tahminde Bulundunuz.");
                    enteredNumber.setText(" ");
                }
                kalanHak--;
                remain.setText("Kalan Hak = " + kalanHak);

                if (kalanHak == 0 && tahminDogrumu == false)
                    sonucGoster("Tahmin Hakkınız Bitti.");
            } else
                info.setText("Oyun Bitti.");

        } else
            info.setText("Lütfen Sayı Giriniz.");
    }

    private void sonucGoster(String mesaj) {
        enteredNumber.setEnabled(false);
        info.setText(mesaj);

    }

}
