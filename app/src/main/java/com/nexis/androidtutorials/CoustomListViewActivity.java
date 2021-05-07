package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CoustomListViewActivity extends AppCompatActivity {

    private String[] meyveler = {"Muz", "Kiraz", "Elma", "Çilek"};
    private int[] kaloriler = {25, 20, 15, 30};
    private int[] resimler = {R.drawable.jerry, R.drawable.jerry, R.drawable.jerry, R.drawable.jerry};

    private MeyveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustom_list_view);

        ListView coustomListView = (ListView)findViewById(R.id.coustomListView);
        adapter = new MeyveAdapter(meyveler,kaloriler,resimler, this);
        coustomListView.setAdapter(adapter);

        coustomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), meyveler[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}