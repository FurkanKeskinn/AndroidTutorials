package com.nexis.androidtutorials.UseListAndDialogActivity.ListViewActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.nexis.androidtutorials.R;

public class DetailsActivity extends AppCompatActivity {
    private String sAciklama, sIsim;
    private Bitmap secilenSehir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView sehirIsmi = (TextView)findViewById(R.id.TextViewDetailsSehir);
        TextView sehirAcıklama = (TextView)findViewById(R.id.TextViewDetailsAcıklama);
        ImageView sehirResmi = (ImageView)findViewById(R.id.ImageViewDetails);


        sIsim = ListViewActivity.sehir.getIsim();
        sAciklama = ListViewActivity.sehir.getAciklama();
        secilenSehir = ListViewActivity.sehir.getResim();

        if (!TextUtils.isEmpty(sIsim) && !TextUtils.isEmpty(sAciklama)){
            sehirAcıklama.setText(sAciklama);
            sehirIsmi.setText(sIsim);
            sehirResmi.setImageBitmap(secilenSehir);

        }
    }
}