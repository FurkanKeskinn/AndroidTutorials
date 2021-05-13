package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalculate = (Button) findViewById(R.id.button_calculate);
        Button estimatingNumbers = (Button) findViewById(R.id.estimating_numbers);
        Button imageActivity = (Button) findViewById(R.id.imageTest);
        Button signUpPage = (Button) findViewById(R.id.signUppage);
        Button buttonAndBar = (Button) findViewById(R.id.buttonAndBar);
        Button randomOperation = (Button) findViewById(R.id.randomOperation);
        Button switchPages = (Button) findViewById(R.id.SwitchPagesActivity);
        Button countersButton = (Button) findViewById(R.id.countersButton);
        Button nameCityGameButton = (Button) findViewById(R.id.nameCityGameButton);
        Button activityListUses = (Button) findViewById(R.id.activityListUses);
        Button buttondialogActivity = (Button) findViewById(R.id.buttondialogActivity);
        Button buttonMenuActivity = (Button) findViewById(R.id.buttonMenuActivity);
        Button buttonContextMenu = (Button) findViewById(R.id.buttonContextMenu);
        Button buttonCustomDialog = (Button) findViewById(R.id.buttonCustomDialog);
        Button buttonBottomNavigationView = (Button) findViewById(R.id.buttonBottomNavigationView);
        Button buttonNavigationView = (Button) findViewById(R.id.buttonNavigationView);
        Button buttonSharedPreferences = (Button) findViewById(R.id.buttonSharedPreferences);
        Button buttonSQLite = (Button) findViewById(R.id.buttonSQLite);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CalculateActivity.class));
            }

        });

        estimatingNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EstimatingNumbers.class));
            }
        });

        imageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

        signUpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpPage.class));
            }
        });

        buttonAndBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ButtonAndBarActivity.class));
            }
        });

        randomOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RandomOperationActivity.class));
            }
        });

        switchPages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SwitchPages.class));
            }
        });

        countersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CountersActivity.class));
            }
        });

        nameCityGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NameCityGame.class));
            }
        });
        activityListUses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UseListActivity.class));

            }
        });

        buttondialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));

            }
        });

        buttonMenuActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MenuActivity.class));

            }
        });

        buttonContextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContextMenuActivity.class));

            }
        });

        buttonCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomDialogActivity.class));

            }
        });

        buttonBottomNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BottomNavigationViewActivity.class));

            }
        });

        buttonNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));

            }
        });

        buttonSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SharedPreferencesActivity.class));

            }
        });

        buttonSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SQLiteActivity.class));

            }
        });
    }

}