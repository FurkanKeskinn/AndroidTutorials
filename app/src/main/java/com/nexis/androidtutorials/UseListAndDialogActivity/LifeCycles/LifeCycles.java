package com.nexis.androidtutorials.UseListAndDialogActivity.LifeCycles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nexis.androidtutorials.R;

public class LifeCycles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycles);
        System.out.println("OnCreate Çalıştı");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("OnResume Çalıştı.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("OnStart Çalıştı.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("OnDestroy Çalıştı");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OnPause Çalıştı.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("OnStop Çalıştı.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("OnRestart Çalıştı.");
    }

    public void secondActivity(View v){
        Intent intent = new Intent(this, LifeCycles2.class);
        finish();
        startActivity(intent);
    }
}