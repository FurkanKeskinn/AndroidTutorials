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
        Button coustomListViewButton = (Button) findViewById(R.id.coustomListViewButton);
        Button GridViewButton = (Button) findViewById(R.id.GridViewButton);
        Button buttonCoustomGridVİew = (Button) findViewById(R.id.buttonCoustomGridVİew);
        Button buttonRecyclerView = (Button) findViewById(R.id.buttonRecyclerView);

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
        coustomListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, CoustomListViewActivity.class));

            }
        });
        GridViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, GridViewActivity.class));

            }
        });
        buttonCoustomGridVİew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, CoustomGridViewActivity.class));

            }
        });

        buttonRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, RecyclerViewActivity.class));

            }
        });
    }

}