package com.nexis.androidtutorials.MyBookListActivity;

import android.graphics.Bitmap;
import android.widget.ScrollView;

public class BookDetail {
    private String kitapAdi, kitapYazari, kitapOzeti;
    private Bitmap kitapResmi;

    public BookDetail(String kitapAdi, String kitapYazari, String kitapOzeti, Bitmap kitapResmi) {
        this.kitapAdi = kitapAdi;
        this.kitapYazari = kitapYazari;
        this.kitapOzeti = kitapOzeti;
        this.kitapResmi = kitapResmi;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public String getKitapOzeti() {
        return kitapOzeti;
    }

    public Bitmap getKitapResmi() {
        return kitapResmi;
    }
}
