package com.nexis.androidtutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class NavigationViewActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        mDrawer = (DrawerLayout)findViewById(R.id.drawerLayout_NavigationView);
        mNav = (NavigationView)findViewById(R.id.navigationView_Id);
        mToolbar = (Toolbar)findViewById(R.id.toolbar_NavigationView);

        setSupportActionBar(mToolbar);
    }
}