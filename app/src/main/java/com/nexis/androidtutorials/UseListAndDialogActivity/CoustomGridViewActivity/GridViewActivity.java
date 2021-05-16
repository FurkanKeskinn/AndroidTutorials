package com.nexis.androidtutorials.UseListAndDialogActivity.CoustomGridViewActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.nexis.androidtutorials.R;

public class GridViewActivity extends AppCompatActivity {
    private String[] numbers = {"1","2","3","4","5","6","7","8","9","10", "11","12","13"};
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView idGridWiew = (GridView)findViewById(R.id.idGridWiew);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);
        idGridWiew.setAdapter(adapter);

        idGridWiew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), numbers[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}