package com.nexis.androidtutorials.UseListAndDialogActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nexis.androidtutorials.R;
import com.nexis.androidtutorials.UseListAndDialogActivity.CoustomGridViewActivity.CoustomGridViewActivity;
import com.nexis.androidtutorials.UseListAndDialogActivity.CoustomGridViewActivity.GridViewActivity;
import com.nexis.androidtutorials.UseListAndDialogActivity.CoustomListViewActivity.CoustomListViewActivity;
import com.nexis.androidtutorials.UseListAndDialogActivity.LifeCycles.LifeCycles;
import com.nexis.androidtutorials.UseListAndDialogActivity.ListViewActivity.DetailsActivity;
import com.nexis.androidtutorials.UseListAndDialogActivity.RecyclerViewActivity.RecyclerViewActivity;

public class UseListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_list);


        Button ListViewActivity = (Button) findViewById(R.id.ListViewActivity);
        Button buttonDetailsActivity = (Button) findViewById(R.id.buttonDetailsActivity);
        Button coustomListViewButton = (Button) findViewById(R.id.coustomListViewButton);
        Button GridViewButton = (Button) findViewById(R.id.GridViewButton);
        Button buttonCoustomGridVÄ°ew = (Button) findViewById(R.id.buttonCoustomGridVÄ°ew);
        Button buttonRecyclerView = (Button) findViewById(R.id.buttonRecyclerView);
        Button buttonLifeCycles = (Button) findViewById(R.id.buttonLifeCycles);
        Button buttonProrgamMatic = (Button) findViewById(R.id.buttonProrgamMatic);

        ListViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, com.nexis.androidtutorials.UseListAndDialogActivity.ListViewActivity.ListViewActivity.class));
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
        buttonCoustomGridVÄ°ew.setOnClickListener(new View.OnClickListener() {
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

        buttonLifeCycles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, LifeCycles.class));

            }
        });

        buttonProrgamMatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseListActivity.this, ProgrammaticActivity.class));

            }
        });

    }

}