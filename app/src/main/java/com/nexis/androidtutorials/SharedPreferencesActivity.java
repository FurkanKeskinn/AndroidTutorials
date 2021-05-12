package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText editTextUserName, editTextPassword;
    private CheckBox checkBox;
    private String userName, userPassword, getUserName;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        editTextUserName = (EditText)findViewById(R.id.editText_SharedPreferencesUserName);
        editTextPassword = (EditText)findViewById(R.id.editText_SharedPreferencesPassword);
        checkBox = (CheckBox)findViewById(R.id.checkBox_SharedPreferences);

        preferences = this.getSharedPreferences("com.nexis.androidtutorials", Context.MODE_PRIVATE);
        getUserName = preferences.getString("username", null);
        check = preferences.getBoolean("checkbox",false);

        if (check && !TextUtils.isEmpty(getUserName)) {
            editTextUserName.setText(getUserName);
            checkBox.setChecked(check);
        }
    }

    public void buttonSignIn(View v){
        userName = editTextUserName.getText().toString();
        userPassword = editTextPassword.getText().toString();

        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword)) {
            if (checkBox.isChecked()){
                editor = preferences.edit();
                editor.putString("username",userName);
                editor.putBoolean("checkbox",true);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Kullanıcı Adınız Başarılı Bir Şekilde Kayıt Yapıldı.",Toast.LENGTH_SHORT).show();
            }else
                editor = preferences.edit();
                editor.putString("username",null);
                editor.putBoolean("checkbox",false);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Başarılı Bir Şekilde Giriş Yapıldı.",Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(getApplicationContext(), "Kullanıcı Adı veya Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();


    }
}