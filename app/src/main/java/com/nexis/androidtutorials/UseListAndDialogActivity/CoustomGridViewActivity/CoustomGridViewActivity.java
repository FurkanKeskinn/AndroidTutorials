package com.nexis.androidtutorials.UseListAndDialogActivity.CoustomGridViewActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

public class CoustomGridViewActivity extends AppCompatActivity {

    private String[] animals = {"At", "Fil", "Kedi", "Köpek", "Kurt", "Ördek" , "Panda", "Papağan","Sincap", "Tavşan", "Tilki" };
    private int[] fotos = {R.drawable.jerry, R.drawable.jerry, R.drawable.jerry, R.drawable.jerry,R.drawable.jerry,
            R.drawable.jerry, R.drawable.jerry, R.drawable.jerry,R.drawable.jerry,R.drawable.jerry,R.drawable.jerry};

    private AnimalsAdpater adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustom_grid_view);

        GridView idCoustomGridView = (GridView)findViewById(R.id.idCoustomGridView);
        adapter = new AnimalsAdpater(animals, fotos, this);
        idCoustomGridView.setAdapter(adapter);

        idCoustomGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), animals[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}