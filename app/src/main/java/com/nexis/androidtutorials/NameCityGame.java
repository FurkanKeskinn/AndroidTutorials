package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameCityGame extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_city_game);

       /* Button buttonNormalGame = (Button)findViewById(R.id.buttonNormalGame);
        Button buttonTimeGame = (Button)findViewById(R.id.buttonTimeGame);*/

        /*buttonNormalGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NameCityGame.this, NormalGameActivity.class));
            }

        });

        buttonTimeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NameCityGame.this, TimeGameActivity.class));
            }

        });*/

    }



        //-------------Ekran İçinde Ekrana Geçmek İçin 2.yöntem---------


    public void buttonHome(View v){
        switch (v.getId()){
            case R.id.buttonNormalGame:
                aktiviteyeGec("NormalOyun");
                break;
            case R.id.buttonTimeGame:
                aktiviteyeGec("SureliOyun");

                break;
            case R.id.buttonExit:
                LogOut();
                break;
        }
    }
    private void aktiviteyeGec(String aktiviteIsmi){
        if(aktiviteIsmi.equals("NormalOyun"))
            intent = new Intent(this,NormalGameActivity.class);
        else
        intent = new Intent(this,TimeGameActivity.class);

        startActivity(intent);
    }

    //-----Uygulamadan çıkarken arka planda hala çalışmaması için geri tuşuna ve çıkış tuşuna basınca uygulamayı tamamen kapatma kodları
    private void LogOut(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        LogOut();
    }
}