package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SwitchPages extends AppCompatActivity {
    private EditText kullaniciAdi, sifre;
    private TextView textSonuc;
    private String kName, kPassword, dogruKName = "Mustafa", dogruKPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_pages);
        kullaniciAdi = (EditText)findViewById(R.id.editTextUsername);
        sifre = (EditText)findViewById(R.id.editTextPassword);
        textSonuc = (TextView)findViewById(R.id.textViewLogIn);

    }

    public void buttonLogIn(View v){
        kName = kullaniciAdi.getText().toString();
        kPassword = sifre.getText().toString();

        if(!TextUtils.isEmpty(kName)){
            if(!TextUtils.isEmpty(kPassword)){
                if(kName.equals(dogruKName)){
                    if(kPassword.equals(dogruKPassword)){

                        Intent intent = new Intent(SwitchPages.this,NewPagesActivity.class);

                        intent.putExtra("kullaniciAdi" , kName);
                        finish();
                    startActivity(intent);

                    }else
                        textSonuc.setText("Şifrenizi yanlış Girdiniz.");
                }else
                    textSonuc.setText("Kullanıcı Adınızı Yanlış Girdiniz.");
            }else
                textSonuc.setText("Şifrenizi Adınızı Boş Giremezsiniz");
        }else
            textSonuc.setText("Kullanıcı Adınızı Boş Giremezsiniz");

    }
}