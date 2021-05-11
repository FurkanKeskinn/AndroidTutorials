package com.nexis.androidtutorials;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationViewActivity extends AppCompatActivity {

    private BottomNavigationView mbottombar;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        mbottombar = (BottomNavigationView)findViewById(R.id.IdBottomNavigationView);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();

        setFragment(homeFragment);

        mbottombar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottombar_menu_home:
                        setFragment(homeFragment);
                    return true;

                    case R.id.bottombar_menu_search:
                        setFragment(searchFragment);
                        return true;

                    case R.id.bottombar_menu_profile:
                        setFragment(profileFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.bottomNavigationView_frameLayout, fragment);
        transaction.commit();
    }
}