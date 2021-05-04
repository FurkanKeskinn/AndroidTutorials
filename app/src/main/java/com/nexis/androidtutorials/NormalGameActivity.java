package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class NormalGameActivity extends AppCompatActivity {

    private TextView textIlBilgi, textIl;
    private EditText editTextTextTahminScreen;
    private String[] iller = {"İstanbul","Ankara","İzmir","Adana","Adıyaman","Afyonkarahisar",
            "Ağrı","Aksaray","Amasya","Antalya","Ardahan","Artvin","Aydın","Balıkesir",
            "Bartın","Batman","Bayburt","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa",
            "Çanakkale","Çankırı","Çorum","Denizli","Diyarbakır","Düzce","Edirne","Elazığ",
            "Erzincan","Erzurum","Eskişehir","Gaziantep","Giresun","Gümüşhane","Hakkari",
            "Hatay","Iğdır","Isparta","Kahramanmaraş","Karabük","Karaman","Kars",
            "Kastamonu","Kayseri","Kırıkkale","Kırklareli","Kırşehir","Kilis","Kocaeli",
            "Konya","Kütahya","Malatya","Manisa","Mardin","Mersin","Muğla","Muş",
            "Nevşehir","Niğde","Ordu","Osmaniye","Rize","Sakarya","Samsun","Siirt","Sinop",
            "Sivas","Şırnak","Tekirdağ","Tokat","Trabzon","Tunceli","Şanlıurfa","Uşak",
            "Van","Yalova","Yozgat","Zonguldak"};


    private Random rndmIl, rndmHarf;
    private int rndmNumber, rndmNumberHarf;
    private String rndmGelenIl, ilBoyutu, editTxtGelenTahmin;
    private ArrayList<Character> ilHarfleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);

        textIlBilgi = (TextView)findViewById(R.id.textIlBilgi);
        textIl = (TextView)findViewById(R.id.textIl);
        editTextTextTahminScreen = (EditText)findViewById(R.id.editTextTextTahminScreen);

        rndmHarf = new Random();
        randomDegerleriBelirle();


    }

    public void tahminOnClick(View v){
        editTxtGelenTahmin = editTextTextTahminScreen.getText().toString();

        if (!TextUtils.isEmpty(editTxtGelenTahmin)) {
            if (editTxtGelenTahmin.equals(rndmGelenIl)){
                editTextTextTahminScreen.setText("");
                System.out.println("Doğru Tahminde Bulundunuz.");
                randomDegerleriBelirle();


        }else
                System.out.println("Yanlış Tahminde Bulundunuz.");
        }else
            System.out.println("Tahmin Değeri boş Olamaz.");
    }

    public void HarfAlOnClick(View v){
        if(ilHarfleri.size() > 0) {
            rndmNumberHarf = rndmHarf.nextInt(ilHarfleri.size());
            String[] txtHarfler = textIl.getText().toString().split(" ");
            char[] gelenIlHarfler = rndmGelenIl.toCharArray();

            for (int i = 0; i < rndmGelenIl.length(); i++){
                if(txtHarfler[i].equals("_")  && gelenIlHarfler[i] == ilHarfleri.get(rndmNumberHarf)){
                    txtHarfler[i] = String.valueOf(ilHarfleri.get(rndmNumberHarf));
                    ilBoyutu = "";

                    for (int j = 0; j < rndmGelenIl.length(); j++){
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

    private void randomDegerleriBelirle(){
        ilBoyutu = "";
        rndmIl = new Random();
        rndmNumber = rndmIl.nextInt(iller.length);
        rndmGelenIl = iller[rndmNumber];
        System.out.println(rndmNumber + " = " + rndmGelenIl);
        textIlBilgi.setText(rndmGelenIl.length() + " Harfli İlimiz");

        for (int i = 0; i < rndmGelenIl.length(); i++) {
            if (i < rndmGelenIl.length() - 1)
                ilBoyutu += "_ ";
            else
                ilBoyutu += "_";

        }
        textIl.setText(ilBoyutu);
        ilHarfleri = new ArrayList<>();

        for (char c : rndmGelenIl.toCharArray() )
            ilHarfleri.add(c);
    }
}



