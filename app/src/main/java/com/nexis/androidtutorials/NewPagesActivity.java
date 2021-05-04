package com.nexis.androidtutorials;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class NewPagesActivity extends AppCompatActivity {

    private TextView textViewUser;
    private String gelenKName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pages);
        textViewUser = (TextView)findViewById(R.id.textViewUser);

        Intent gelenIntent = getIntent();
        gelenKName = gelenIntent.getStringExtra("kullaniciAdi");
        textViewUser.setText("Hoşgeldiniz = "+gelenKName);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(NewPagesActivity.this, SwitchPages.class);
        finish();
        startActivity(backIntent);
    }
}