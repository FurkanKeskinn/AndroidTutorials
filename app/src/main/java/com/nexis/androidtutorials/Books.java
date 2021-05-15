package com.nexis.androidtutorials;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Books {
    private String kitapAdi, kitapYazari, kitapOzeti;
    private Bitmap kitapResim;

    public Books(){}

    public Books(String kitapAdi, String kitapYazari, String kitapOzeti, Bitmap kitapResim) {
        this.kitapAdi = kitapAdi;
        this.kitapYazari = kitapYazari;
        this.kitapOzeti = kitapOzeti;
        this.kitapResim = kitapResim;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public void setKitapYazari(String kitapYazari) {
        this.kitapYazari = kitapYazari;
    }

    public String getKitapOzeti() {
        return kitapOzeti;
    }

    public void setKitapOzeti(String kitapOzeti) {
        this.kitapOzeti = kitapOzeti;
    }

    public Bitmap getKitapResim() {
        return kitapResim;
    }

    public void setKitapResim(Bitmap kitapResim) {
        this.kitapResim = kitapResim;
    }

    static public ArrayList<Books> getData(){
        ArrayList<Books> bookList = new ArrayList<>();

    }
}
