package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class CountersActivity extends AppCompatActivity {

    private TextView textCount;
    //private CountDownTimer geriSayac;
    private Runnable ileriSayacRunnable;
    private Handler  ileriSayacHandler;
    private int sayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counters);

        textCount = (TextView) findViewById(R.id.textViewCount);
    }


    public void onClickSayac(View v) {
        sayi =0;
        // 1000= 1saniye

        //-----Geriye Doğru Sayan Sayaç-----

        /* new CountDownTimer(10100, 1000) {
            @Override
            public void onTick(long l) {
                textCount.setText("Kalan = "+ (l / 1000));

            }

            @Override
            public void onFinish() {
                textCount.setText("Kalan = 0" );

            }
        }.start();*/


        /*geriSayac = new CountDownTimer(5100, 1000) {
            @Override
            public void onTick(long l) {
                textCount.setText("Kalan = "+ (l / 1000));

            }

            @Override
            public void onFinish() {
                textCount.setText("Kalan = 0" );

            }
        };

        geriSayac.start();*/

        //-----İleriye Doğru Sayan Sayaç-----


        ileriSayacHandler = new Handler();
        ileriSayacRunnable = new Runnable() {
            @Override
            public void run() {
                textCount.setText("Sayım = " + sayi);
                sayi++;
                ileriSayacHandler.postDelayed(ileriSayacRunnable,1000);

            }
        };
        ileriSayacHandler.post(ileriSayacRunnable);
    }

    public void onClickRunnable(View v){
        ileriSayacHandler.removeCallbacks(ileriSayacRunnable);

    }
}