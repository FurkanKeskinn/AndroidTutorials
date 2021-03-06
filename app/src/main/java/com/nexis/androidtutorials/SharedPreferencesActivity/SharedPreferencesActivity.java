package com.nexis.androidtutorials.SharedPreferencesActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

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

                Toast.makeText(getApplicationContext(), "Kullan??c?? Ad??n??z Ba??ar??l?? Bir ??ekilde Kay??t Yap??ld??.",Toast.LENGTH_SHORT).show();
            }else
                editor = preferences.edit();
                editor.putString("username",null);
                editor.putBoolean("checkbox",false);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Ba??ar??l?? Bir ??ekilde Giri?? Yap??ld??.",Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(getApplicationContext(), "Kullan??c?? Ad?? veya ??ifre Bo?? Olamaz.", Toast.LENGTH_SHORT).show();


    }
}