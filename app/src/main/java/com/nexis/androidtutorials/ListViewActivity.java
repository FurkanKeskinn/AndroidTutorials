package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private String[] citys = {"Ankara", "Adana", "İstanbul", "İzmir", "Malatya", "Bolu", "Gaziantep",
            "Aydın", "Van", "Muğla", "Muş", "Kahramanmaraş", "Batman", "Mardin", "Diyarbakır", "Bursa"};

    private String[] sehirlerAciklama = {"Türkiye'nin başkenti ve en kalabalık ikinci ilidir.[6] Nüfusu 2020 itibarıyla 5.663.322 kişidir. Bu nüfus; 25 ilçe ve bu ilçelere bağlı 1425 mahallede yaşamaktadır. İl genelinde nüfus yoğunluğu 215'tir. Nüfuslarına göre şehirler listesinde belediye sınırları göz önüne alınarak yapılan sıralamaya göre dünyada ise elli yedinci sırada yer almaktadır",
            "Türkiye'nin bir ili ve en kalabalık altıncı şehridir. 2019 yılı verilerine göre 2.258.718 nüfusa sahiptir. İlin yüz ölçümü 13.844 km2'dir. İlde km2'ye 160 kişi düşmektedir",
            "Türkiye'de Marmara Bölgesi'nde yer alan şehir ve ülkenin 81 ilinden biri. Ülkenin en kalabalık, ekonomik, tarihi ve sosyo-kültürel açıdan önde gelen şehridir.[6][7][8] Şehir, iktisadi büyüklük açısından dünyada 34. sırada yer alır. Nüfuslarına göre şehirler listesinde belediye sınırları göz önüne alınarak yapılan sıralamaya göre Avrupa'da birinci, dünyada ise altıncı sırada yer almaktadır",
            "Türkiye'nin bir ili ve en kalabalık üçüncü şehridir. Nüfusu 2020 itibarıyla 4.394.694 kişidir. Bu nüfus; 30 ilçe ve bu ilçelere bağlı 1.297 mahallede yaşamaktadır",
            " Türkiye'de yer alan şehir ve ülkenin 81 ilinden biridir. Ülkenin en kalabalık 28. şehri olan Malatya, 2020 itibarıyla 806.156 kişilik nüfusa sahiptir."};

    private Intent detailsIntent;
    private int[] sehirlerResim = {R.drawable.jerry, R.drawable.jerry, R.drawable.jerry, R.drawable.jerry, R.drawable.jerry};
    private Bitmap secilenSehir;
    static public Sehir sehir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView mListView = (ListView) findViewById(R.id.listView_activitiy);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citys);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (i < 5) {
                    detailsIntent = new Intent(ListViewActivity.this, DetailsActivity.class);
                    sehir = new Sehir(sehirlerAciklama[i], citys[i], secilenSehir);

                   secilenSehir = BitmapFactory.decodeResource(getApplicationContext().getResources(), sehirlerResim[i]);
                    startActivity(detailsIntent);
                }
            }
        });
    }
}