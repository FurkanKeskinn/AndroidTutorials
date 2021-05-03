package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUpPage extends AppCompatActivity {
    private EditText editTextAd, editTextSoyad, editTextCity, editTextYas;
    private CheckBox checkBox1, checkBox2, checkBox3;
    private RadioButton radioButtonMan, radioButtonWoman;

    private String editAd, editSoyad, editCity, editYas;
    private String checkText1, checkText2, checkText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        //EditText
        editTextAd = (EditText) findViewById(R.id.editTextAd);
        editTextSoyad = (EditText) findViewById(R.id.editTextSoyad);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        editTextYas = (EditText) findViewById(R.id.editTextYas);

        //Checkbox
        checkBox1 = (CheckBox) findViewById(R.id.checkHobi1);
        checkBox2 = (CheckBox) findViewById(R.id.checkHobi2);
        checkBox3 = (CheckBox) findViewById(R.id.checkHobi3);

        //RadioButton
         radioButtonMan = (RadioButton) findViewById(R.id.radioWoman);
         radioButtonWoman = (RadioButton) findViewById(R.id.radioWoman);

    }

    public void signUpButton(View v) {
        editAd = editTextAd.getText().toString();
        editSoyad = editTextSoyad.getText().toString();
        editCity = editTextCity.getText().toString();
        editYas = editTextYas.getText().toString();

        if (!TextUtils.isEmpty(editAd) && !TextUtils.isEmpty(editSoyad) && !TextUtils.isEmpty(editCity) && !TextUtils.isEmpty(editYas)) {

            System.out.println("------Bilgileriniz------");

            System.out.println("Adınız : " + editAd);
            System.out.println("Soyadınız : " + editSoyad);
            System.out.println("Şehriniz : " + editCity);
            System.out.println("Yaşınız : " + editYas);


            System.out.println("------Hobileriniz--------");
            if (checkBox1.isChecked())
                System.out.println(checkBox1.getText().toString());
            if (checkBox2.isChecked())
                System.out.println(checkBox2.getText().toString());
            if (checkBox3.isChecked())
                System.out.println(checkBox3.getText().toString());

            if (radioButtonMan.isChecked()) {
                System.out.println("Cinsiyetiniz : " + radioButtonMan.getText().toString());
            } else {
                System.out.println("Cinsiyetiniz : " + radioButtonWoman.getText().toString());
            }
            System.out.println("Kayıt işleminiz Tamamlandı");

        }else
            System.out.println("Bilgilerinizin Hepsini Lütfen Doldurun");

    }
}