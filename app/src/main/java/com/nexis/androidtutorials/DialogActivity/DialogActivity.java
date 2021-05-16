package com.nexis.androidtutorials.DialogActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

import static android.content.DialogInterface.*;

public class DialogActivity extends AppCompatActivity {

    private AlertDialog.Builder alert;
    private String secim = "Seçtikleriniz : ";
    private String[] isletimSistemleri = {"Windows 10", "Windows 98", "Windows Xp", "Windows 7"};
    private boolean[] secimler = {true , false , true, true};

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
        alert.setPositiveButton("hayır", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        alert.setNegativeButton("Evet", new OnClickListener() {
            @Override
            public void onClick(DialogInterface DialogInterface, int which) {
                Toast.makeText(getApplicationContext(),"Çıkışa Bastın", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();


    }

    public void alertDialog(View v){

        alert = new AlertDialog.Builder(this);
        alert.setTitle("İşletim Sistem Türünüzü Seçiniz : ");
        DialogInterface.OnMultiChoiceClickListener lisetener = new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if(isChecked) {
                    secim +=  "\n" + isletimSistemleri[which] ;

                    Toast.makeText(getApplicationContext(), isletimSistemleri[which],Toast.LENGTH_SHORT).show();
                }
            }
        };
        alert.setMultiChoiceItems(isletimSistemleri, secimler, lisetener);
        alert.setPositiveButton("Tamam", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),secim, Toast.LENGTH_SHORT).show();
                secim = "Seçtikleriniz : ";
            }
        });

        alert.show();
        }
    }

