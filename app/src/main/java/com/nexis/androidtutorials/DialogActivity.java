package com.nexis.androidtutorials;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void normalAlertDialog(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Kütüphane Otomasyonu");
        alert.setMessage("Uygulamadan Çıkmak İstediğinize Emin Misiniz ?");
        alert.setCancelable(false);
        alert.setIcon(R.mipmap.ic_launcher);
        alert.setPositiveButton("hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        alert.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface DialogInterface, int which) {
                Toast.makeText(getApplicationContext(),"Çıkışa Bastın", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();


    }
}