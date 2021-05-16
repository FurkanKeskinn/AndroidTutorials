package com.nexis.androidtutorials.MyBookListActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexis.androidtutorials.R;

public class MyBookListDetailsActivity extends AppCompatActivity {

    private ImageView imageBookFoto;
    private TextView textBookName, textBookWriter, textBookSummery;
    private String kitapAdi, kitapYazari, kitapOzeti;
    private Bitmap kitapResmi;

    private void init() {
        imageBookFoto = (ImageView) findViewById(R.id.myBookList_Details_Activity_imageViewBookFoto);
        textBookName = (TextView) findViewById(R.id.myBookList_Details_Activity_textViewBookName);
        textBookWriter = (TextView) findViewById(R.id.myBookList_Details_Activity_textViewBookWriter);
        textBookSummery = (TextView) findViewById(R.id.myBookList_Details_Activity_textViewBookSummery);

        kitapAdi = MyBookListActivity.bookDetail.getKitapAdi();
        kitapYazari = MyBookListActivity.bookDetail.getKitapYazari();
        kitapOzeti = MyBookListActivity.bookDetail.getKitapOzeti();
        kitapResmi = MyBookListActivity.bookDetail.getKitapResmi();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book_list_details);
        init();

        if (!TextUtils.isEmpty(kitapAdi) && !TextUtils.isEmpty(kitapYazari) && !TextUtils.isEmpty(kitapOzeti))
        textBookName.setText(kitapAdi);
        textBookWriter.setText(kitapYazari);
        textBookSummery.setText(kitapOzeti);
        imageBookFoto.setImageBitmap(kitapResmi);
    }
}