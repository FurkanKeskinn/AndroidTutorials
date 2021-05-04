package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Random;

public class RandomOperationActivity extends AppCompatActivity {

    private ArrayList<String> islemTurleri;
    private TextView randomTopla, randomCıkar, randomCarp, randomBol, randomSoru;
    private ToggleButton toggleTopla, toggleCıkar, toggleCarp, toggleBol;
    private EditText editTextQuestion;
    private Random  randomSayi;
    private int randomIslemNumber, randomSayiNumber;
    private String soru, textTahmin;
    private int s1, s2, sonuc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_operation);

        islemTurleri = new ArrayList<>();

        randomSayi = new Random();

    toggleTopla = (ToggleButton)findViewById(R.id.toggleTopla);
    toggleCıkar = (ToggleButton)findViewById(R.id.toggleCıkar);
    toggleCarp = (ToggleButton)findViewById(R.id.toggleCarp);
    toggleBol = (ToggleButton)findViewById(R.id.toggleBol);

         randomTopla = (TextView)findViewById(R.id.randomTopla);
         randomCıkar = (TextView)findViewById(R.id.randoCıkar);
         randomCarp = (TextView)findViewById(R.id.randomCarp);
         randomBol = (TextView)findViewById(R.id.randomBol);
         randomSoru = (TextView)findViewById(R.id.randomSoru);

         editTextQuestion = (EditText)findViewById(R.id.editTextQuestion);

        Button buttonSoruGetir = (Button)findViewById(R.id.buttonSoruGetir);
        Button buttonTahmin = (Button)findViewById(R.id.buttonTahmin);

        toggleTopla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                    islemTurleri.add("+");
                else
                    islemTurleri.remove("+");
            }
        });

        toggleCıkar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                    islemTurleri.add("-");
                else
                    islemTurleri.remove("-");
            }
        });

        toggleCarp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                    islemTurleri.add("*");
                else
                    islemTurleri.remove("*");
            }
        });

        toggleBol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                    islemTurleri.add("/");
                else
                    islemTurleri.remove("/");
            }
        });

    }
    public void buttonClick(View v){
        switch (v.getId()){
            case R.id.buttonSoruGetir:
                randomSoru.setText(islemTurunuVeSoruyuBelirle());
                break;

            case R.id.buttonTahmin:
                tahminControle();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
    private void tahminControle(){
        textTahmin = editTextQuestion.getText().toString();
        if(!TextUtils.isEmpty(textTahmin)) {
            if (textTahmin.matches(String.valueOf(sonuc))) {
                System.out.println("Tebrikle Doğru Tahminde Bulundunuz.");
                editTextQuestion.setText("");
                randomSoru.setText(islemTurunuVeSoruyuBelirle());
            } else
                System.out.println("Yanlış Tahminde Bulundunuz");
        }else
            System.out.println("Lütfen Tahmin Değerinizi Giriniz.");
    }
    private String islemTurunuVeSoruyuBelirle(){
        soru = "";
        if(islemTurleri.size() > 0){
            randomIslemNumber = randomSayi.nextInt(islemTurleri.size());

            s1 += rndmSayiGetir();
            soru += s1;
            soru += " ";

            soru += islemTurleri.get(randomIslemNumber);
            soru += " ";

            s2 += rndmSayiGetir();
            soru += s2;
            soru += " = ?";
            switch (islemTurleri.get(randomIslemNumber)){
                case "+":
                    sonuc = s1 + s2;
                    break;

                case "-":
                    sonuc = s1 - s2;
                    break;

                case "*":
                    sonuc = s1 * s2;
                    break;

                case "/":
                    sonuc = s1 / s2;
                    break;
            }

        }
       return soru;
    }


    private int rndmSayiGetir(){
        randomSayiNumber = randomSayi.nextInt(10)+1;
        return randomSayiNumber;

    }
}