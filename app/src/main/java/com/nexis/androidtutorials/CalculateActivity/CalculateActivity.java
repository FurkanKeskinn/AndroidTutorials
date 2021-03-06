package com.nexis.androidtutorials.CalculateActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nexis.androidtutorials.R;

public class CalculateActivity extends AppCompatActivity {

    private EditText editText1 , editText2;
    private TextView editSonuc;
    private String sayi1, sayi2;
    private int s1, s2, sonuc;
    private Operation hesap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        editText1 = (EditText)findViewById(R.id.editTextId1);
        editText2 = (EditText)findViewById(R.id.editTextId2);
        editSonuc = (TextView)findViewById(R.id.editTextIdSonuc);



        Button clear = (Button)findViewById(R.id.delete);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
                editText2.setText("");
                editSonuc.setText("Sonuç =");
            }
        });

    }
    public  void equals1(View v){
        sayi1 = editText1.getText().toString();
        sayi2 = editText2.getText().toString();

        if (!TextUtils.isEmpty(sayi1) && !TextUtils.isEmpty(sayi2)){

            s1 = Integer.valueOf(sayi1);
            s2 = Integer.valueOf(sayi2);
            hesap = new Operation(s1,s2);

            switch (v.getId()){
                case R.id.plus:
                    sonuc = hesap.topla();
                    break;

                case R.id.minus:
                    sonuc = hesap.fark();
                    break;

                case R.id.multiply:
                    sonuc = hesap.carp();
                    break;

                case R.id.divided:
                    sonuc = hesap.bol();
                    break;



            }
            editSonuc.setText("Sonuç =" + sonuc);
        }
        else editSonuc.setText("Lütfen İki Sayı giriniz");

    }

}



