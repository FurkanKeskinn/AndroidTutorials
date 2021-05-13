package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SQLiteActivity extends AppCompatActivity {

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        try {
            database = this.openOrCreateDatabase("Okul", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Ogrenciler (ad VARCHAR, soyad VARCHAR, ogrenci_no INT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sQLiteButtonOnClick(View v) {
        switch (v.getId()) {
            case R.id.sQLiteButtonAdd:
                try {
                    database.execSQL("INSERT INTO Ogrenciler (ad,soyad,ogrenci_no) VALUES('Mehmet', 'Gün', 104)");
                    getData();
                    Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Eklendi.", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.sQLiteButtonUpdate:
                try {
                    database.execSQL("UPDATE Ogrenciler SET soyad = 'Kılıç', ogrenci_no = 1556 WHERE ad = 'Mehmet' AND soyad = 'Gün'");
                    getData();
                    Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Güncellendi.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.sQLiteButtonDelete:
                try {


                    database.execSQL("DELETE FROM Ogrenciler WHERE soyad= 'Kılıç'");
                    getData();
                    Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Silindi.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.sQLiteButtonDrop:
                try {
                    database.execSQL("DROP TABLE Ogrenciler");
                    getData();
                    Toast.makeText(getApplicationContext(), "Tablo Başarıyla Silindi.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    private void getData() {
        Cursor cursor = database.rawQuery("SELECT * FROM Ogrenciler", null);

        int adIndex = cursor.getColumnIndex("ad");
        int soyadIndex = cursor.getColumnIndex("soyad");
        int ogrenciNoIndex = cursor.getColumnIndex("ogrenci_no");

        while (cursor.moveToNext())
            System.out.println("Ad = " + cursor.getString(adIndex) + " Soyad = " + cursor.getString(soyadIndex) + " No = " + cursor.getInt(ogrenciNoIndex));
        cursor.close();
    }
}