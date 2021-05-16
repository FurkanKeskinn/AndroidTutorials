package com.nexis.androidtutorials;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AddBookActivity extends AppCompatActivity {
    private EditText editTextKitapIsmi, editTextKitapYazari, editTextKitapOzeti;
    private ImageView imageKitapResim;
    private String kitapIsmi, kitapYazari, kitapOzeti;
    private int imageIzinAlmaKodu = 0, imageIzinVerildiKodu = 1;
    private Bitmap secilenResim, kucultulenResim, enbastakiResim;
    private Button buttonSave;

    private void init() {
        editTextKitapIsmi = (EditText) findViewById(R.id.add_book_activity_editTexxtBookName);
        editTextKitapYazari = (EditText) findViewById(R.id.add_book_activity_editTexxtBookWriter);
        editTextKitapOzeti = (EditText) findViewById(R.id.add_book_activity_editTexxtBookSummary);
        imageKitapResim = (ImageView) findViewById(R.id.add_book_activity_imageViewBookImage);
        buttonSave =(Button)findViewById(R.id.add_book_activity_buttonSave);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        init();
    }

    public void BookSaveOnClick(View v) {
        kitapIsmi = editTextKitapIsmi.getText().toString();
        kitapYazari = editTextKitapYazari.getText().toString();
        kitapOzeti = editTextKitapOzeti.getText().toString();

        if (!TextUtils.isEmpty(kitapIsmi)) {
            if (!TextUtils.isEmpty(kitapYazari)) {
                if (!TextUtils.isEmpty(kitapOzeti)) {
                    //Kaydet

                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    kucultulenResim = resimiKucult(secilenResim);
                    kucultulenResim.compress(Bitmap.CompressFormat.PNG, 75, outputStream);
                    byte[] kayitEdilecekResim = outputStream.toByteArray();

                    try {
                        SQLiteDatabase database = this.openOrCreateDatabase("Kitaplar", MODE_PRIVATE, null);
                        database.execSQL("CREATE TABLE IF NOT EXİSTS kitaplar (id INTEGER PRİMARY KEY, kitapAdi VARCHAR, kitapYazari VARCHAR, kitapOzeti VARCHAR, kitapResim BLOB)");

                        String sqlSorgusu = "INSERT INTO kitaplar (kitapAdi,kitapYazari,kitapOzeti,kitapResim) VALUES (?,?,?,?)";
                        SQLiteStatement statement = database.compileStatement(sqlSorgusu);
                        statement.bindString(1,kitapIsmi);
                        statement.bindString(2,kitapYazari);
                        statement.bindString(3,kitapOzeti);
                        statement.bindBlob(4,kayitEdilecekResim);
                        statement.execute();

                        nesneleriTemizle();
                        showToast("Kayıt Başarıyla Eklendi");

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                } else
                    showToast("Kitap Özeti Boş Olamaz.");

            } else
                showToast("Kitap Yazarı Boş Olamaz.");

        } else
            showToast("Kitap İsmi Boş Olamaz.");


    }
    private Bitmap resimiKucult(Bitmap resim){
        return Bitmap.createScaledBitmap(resim,120,150,true);
    }

    private void showToast(String mesaj) {
        Toast.makeText(getApplicationContext(), mesaj, Toast.LENGTH_SHORT).show();
    }

    private void nesneleriTemizle(){
        editTextKitapIsmi.setText("");
        editTextKitapYazari.setText("");
        editTextKitapOzeti.setText("");
        enbastakiResim = BitmapFactory.decodeResource(this.getResources(),R.drawable.resim);
        imageKitapResim.setImageBitmap(enbastakiResim);
        buttonSave.setEnabled(false);
    }

    public void resimSec(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},imageIzinAlmaKodu);

    }else {
            Intent resimiAl = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(resimiAl,imageIzinVerildiKodu);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        if (requestCode== imageIzinAlmaKodu) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent resimiAl = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(resimiAl,imageIzinVerildiKodu);

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == imageIzinVerildiKodu){
           if(resultCode ==  RESULT_OK && data != null){
                Uri resimUri = data.getData();
                try {
                    if (Build.VERSION.SDK_INT >= 28){
                        ImageDecoder.Source  resimSource = ImageDecoder.createSource(this.getContentResolver(),resimUri);
                        secilenResim = ImageDecoder.decodeBitmap(resimSource);
                        imageKitapResim.setImageBitmap(secilenResim);
                    }else {
                        secilenResim = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resimUri);
                        imageKitapResim.setImageBitmap(secilenResim);
                    }

                    buttonSave.setEnabled(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
