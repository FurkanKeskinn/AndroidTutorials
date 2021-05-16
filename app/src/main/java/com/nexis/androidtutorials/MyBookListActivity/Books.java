package com.nexis.androidtutorials.MyBookListActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    static public ArrayList<Books> getData(Context context){
        ArrayList<Books> bookList = new ArrayList<>();
        ArrayList<String> bookNameList = new ArrayList<>();
        ArrayList<String> bookWriterList = new ArrayList<>();
        ArrayList<String> bookSummeryList = new ArrayList<>();
        ArrayList<Bitmap> bookFotoList = new ArrayList<>();

        try {
            SQLiteDatabase database = context.openOrCreateDatabase("Kitaplar", Context.MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT * FROM kitaplar", null);

            int bookNameIndex = cursor.getColumnIndex("kitapAdi");
            int bookWriterIndex = cursor.getColumnIndex("kitapYazari");
            int bookSummeryIndex = cursor.getColumnIndex("kitapOzeti");
            int bookFotoIndex = cursor.getColumnIndex("kitapResim");

            while (cursor.moveToNext()){
                bookNameList.add(cursor.getString(bookNameIndex));
                bookWriterList.add(cursor.getString(bookWriterIndex));
                bookSummeryList.add(cursor.getString(bookSummeryIndex));

                byte[] gelenResimByte = (cursor.getBlob(bookFotoIndex));
                Bitmap gelenResim = BitmapFactory.decodeByteArray(gelenResimByte, 0, gelenResimByte.length);
                bookFotoList.add(gelenResim);

            }
            cursor.close();

            for (int i=0; i<bookNameList.size(); i++){
                Books books = new Books();
                books.setKitapAdi(bookNameList.get(i));
                books.setKitapYazari(bookWriterList.get(i));
                books.setKitapOzeti(bookSummeryList.get(i));
                books.setKitapResim(bookFotoList.get(i));

                bookList.add(books);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;


    }
}
