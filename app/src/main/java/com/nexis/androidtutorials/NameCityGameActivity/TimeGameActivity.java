package com.nexis.androidtutorials.NameCityGameActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

import java.util.ArrayList;
import java.util.Random;

public class TimeGameActivity extends AppCompatActivity {

    private TextView textIlBilgi, textIl, textViewToplamPuan, textTime;
    private EditText editTextTextTahminScreen;
    private Button buttonHarfAlT, tahminButtonT, buttonRestartGameT;
    private String[] iller = {"İstanbul", "Ankara", "İzmir", "Adana", "Adıyaman", "Afyonkarahisar",
            "Ağrı", "Aksaray", "Amasya", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir",
            "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa",
            "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ",
            "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari",
            "Hatay", "Iğdır", "Isparta", "Kahramanmaraş", "Karabük", "Karaman", "Kars",
            "Kastamonu", "Kayseri", "Kırıkkale", "Kırklareli", "Kırşehir", "Kilis", "Kocaeli",
            "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş",
            "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop",
            "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak",
            "Van", "Yalova", "Yozgat", "Zonguldak"};


    private Random rndmIl, rndmHarf;
    private int rndmNumber, rndmNumberHarf, baslangicHarfSayisi, toplamSure = 180000;
    private String rndmGelenIl, ilBoyutu, editTxtGelenTahmin;
    private ArrayList<Character> ilHarfleri;
    private float maximumPuan = 100.0f, reducePuan, toplamPuan = 0, bolumToplamPuan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_game);

        textIlBilgi = (TextView) findViewById(R.id.textIlBilgiT);
        textIl = (TextView) findViewById(R.id.textIlT);
        editTextTextTahminScreen = (EditText) findViewById(R.id.editTextTextTahminScreenT);
        textViewToplamPuan = (TextView) findViewById(R.id.textViewToplamPuanT);
        textTime = (TextView)findViewById(R.id.textTime);
        buttonHarfAlT = (Button)findViewById(R.id.buttonHarfAlT);
        tahminButtonT = (Button)findViewById(R.id.tahminButtonT);
        buttonRestartGameT = (Button)findViewById(R.id.buttonRestartGameT);



        new CountDownTimer(toplamSure, 1000) {
            @Override
            public void onTick(long l) {
                textTime.setText((l / 60000) + ":" + (l % 60000) / 1000);

            }

            @Override
            public void onFinish() {
                textTime.setText("0.00");
                editTextTextTahminScreen.setEnabled(false);
                buttonHarfAlT.setEnabled(false);
                tahminButtonT.setEnabled(false);
                buttonRestartGameT.setVisibility((View.VISIBLE));

                Toast.makeText(getApplicationContext(), "Oyun Bitti\nToplam Puanınız = " + bolumToplamPuan + "\n Tekrar Oynamak İçin Butona Basın", Toast.LENGTH_SHORT).show();



            }
        }.start();

        rndmHarf = new Random();
        randomDegerleriBelirle();
    }

    public void HarfAlOnClickT(View v) {

        if (ilHarfleri.size() > 0) {
            randomHarfAl();
            toplamPuan -= reducePuan;
            Toast.makeText(getApplicationContext(), "Kalan Puan = " + toplamPuan, Toast.LENGTH_SHORT).show();
        } else
        Toast.makeText(getApplicationContext(), "Alınabilecek Harf Kalmadı.", Toast.LENGTH_SHORT).show();



    }
    public void RestartgameOnClick(View v){
        Intent tekrarOyna = new Intent(this, TimeGameActivity.class);
        startActivity(tekrarOyna);
    }



    public void tahminOnClickT(View v) {

        editTxtGelenTahmin = editTextTextTahminScreen.getText().toString();

        if (!TextUtils.isEmpty(editTxtGelenTahmin)) {
            if (editTxtGelenTahmin.equals(rndmGelenIl)) {

                bolumToplamPuan += toplamPuan;
                Toast.makeText(getApplicationContext(), "Tebrikler Doğru Tahminde Bulundunuz.", Toast.LENGTH_SHORT).show();

                textViewToplamPuan.setText("Toplam Bölüm Puanı = " + bolumToplamPuan);

                editTextTextTahminScreen.setText("");
                Toast.makeText(getApplicationContext(), "\"Doğru Tahminde Bulundunuz.", Toast.LENGTH_SHORT).show();
                randomDegerleriBelirle();

            } else
                Toast.makeText(getApplicationContext(), "Yanlış Tahminde Bulundunuz.", Toast.LENGTH_SHORT).show();
        } else
        Toast.makeText(getApplicationContext(), "Tahmin Değeri boş Olamaz.", Toast.LENGTH_SHORT).show();

    }


    private void randomDegerleriBelirle() {
        ilBoyutu = "";
        rndmIl = new Random();
        rndmNumber = rndmIl.nextInt(iller.length);
        rndmGelenIl = iller[rndmNumber];
        System.out.println(rndmNumber + " = " + rndmGelenIl);
        textIlBilgi.setText(rndmGelenIl.length() + " Harfli İlimiz");

        if (rndmGelenIl.length() >= 5 && rndmGelenIl.length() <= 7)
            baslangicHarfSayisi = 1;
        else if (rndmGelenIl.length() >= 8 && rndmGelenIl.length() < 10)
            baslangicHarfSayisi = 2;
        else if (rndmGelenIl.length() >= 10)
            baslangicHarfSayisi = 3;
        else
            baslangicHarfSayisi = 0;

        for (int i = 0; i < rndmGelenIl.length(); i++) {
            if (i < rndmGelenIl.length() - 1)
                ilBoyutu += "_ ";
            else
                ilBoyutu += "_";

        }
        textIl.setText(ilBoyutu);
        ilHarfleri = new ArrayList<>();

        for (char c : rndmGelenIl.toCharArray())
            ilHarfleri.add(c);

        for (int c = 0; c < baslangicHarfSayisi; c++)
            randomHarfAl();


        reducePuan = maximumPuan / ilHarfleri.size();
        toplamPuan = maximumPuan;
    }

    private void randomHarfAl() {
        rndmNumberHarf = rndmHarf.nextInt(ilHarfleri.size());
        String[] txtHarfler = textIl.getText().toString().split(" ");
        char[] gelenIlHarfler = rndmGelenIl.toCharArray();

        for (int i = 0; i < rndmGelenIl.length(); i++) {
            if (txtHarfler[i].equals("_") && gelenIlHarfler[i] == ilHarfleri.get(rndmNumberHarf)) {
                txtHarfler[i] = String.valueOf(ilHarfleri.get(rndmNumberHarf));
                ilBoyutu = "";

                for (int j = 0; j < rndmGelenIl.length(); j++) {
                    if (j == 1)
                        ilBoyutu += txtHarfler[j] + " ";

                    else if (j < rndmGelenIl.length() - 1)
                        ilBoyutu += txtHarfler[j] + " ";
                    else
                        ilBoyutu += txtHarfler[j];


                }
                break;
            }
        }

        textIl.setText(ilBoyutu);
        ilHarfleri.remove(rndmNumberHarf);
    }
}