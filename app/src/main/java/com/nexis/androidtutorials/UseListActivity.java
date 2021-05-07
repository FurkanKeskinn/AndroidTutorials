package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UseListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_list);


        Button ListViewActivity = (Button) findViewById(R.id.ListViewActivity);
        Button buttonDetailsActivity = (Button) findViewById(R.id.buttonDetailsActivity);


        ListViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, ListViewActivity.class));
            }
        });
        buttonDetailsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, DetailsActivity.class));

            }
        });
    }

}