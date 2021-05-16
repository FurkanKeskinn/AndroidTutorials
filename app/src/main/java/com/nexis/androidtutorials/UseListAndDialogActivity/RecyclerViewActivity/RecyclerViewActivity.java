package com.nexis.androidtutorials.UseListAndDialogActivity.RecyclerViewActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private FruitsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView idRexycleView = (RecyclerView)findViewById(R.id.idRexycleView);
        adapter = new FruitsAdapter(Fruits.getData(),this);

        idRexycleView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        idRexycleView.setLayoutManager(manager);
        idRexycleView.setAdapter(adapter);

        adapter.setOnItemClickListener(new FruitsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Fruits fruits, int position) {
                Toast.makeText(getApplicationContext(),fruits.getFruitName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}