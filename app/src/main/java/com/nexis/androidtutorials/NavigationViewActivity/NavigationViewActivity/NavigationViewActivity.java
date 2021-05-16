package com.nexis.androidtutorials.NavigationViewActivity.NavigationViewActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nexis.androidtutorials.NavigationViewActivity.NavigationViewActivity.Fragment.NavigationViewHomeFragment;
import com.nexis.androidtutorials.NavigationViewActivity.NavigationViewActivity.Fragment.NavigationViewProfileFragment;
import com.nexis.androidtutorials.NavigationViewActivity.NavigationViewActivity.Fragment.NavigationViewSearchFragment;
import com.nexis.androidtutorials.R;

public class NavigationViewActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private NavigationView mNav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private NavigationViewHomeFragment homeFragment;
    private NavigationViewSearchFragment searchFragment;
    private NavigationViewProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        mDrawer = (DrawerLayout)findViewById(R.id.drawerLayout_NavigationView);
        mNav = (NavigationView)findViewById(R.id.navigationView_Id);
        mToolbar = (Toolbar)findViewById(R.id.toolbar_NavigationView);

        homeFragment = new NavigationViewHomeFragment();
        profileFragment = new NavigationViewProfileFragment();
        searchFragment = new NavigationViewSearchFragment();

        setSupportActionBar(mToolbar);
        mNav.getMenu().findItem(R.id.nav_menu_fragment1).setChecked(true);
        mNav.setItemIconTintList(null);

        mToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.nav_open, R.string.nav_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_menu_fragment1:
                        setFragment(homeFragment);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_menu_fragment2:
                        setFragment(searchFragment);
                        mNav.getMenu().findItem(R.id.nav_menu_fragment1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_menu_fragment3:
                        setFragment(profileFragment);
                        mNav.getMenu().findItem(R.id.nav_menu_fragment1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_menu_fragment4:
                        Toast.makeText(getApplicationContext(), "Fragment4", Toast.LENGTH_SHORT).show();
                        mNav.getMenu().findItem(R.id.nav_menu_fragment1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_menu_fragment5:
                        Toast.makeText(getApplicationContext(), "Fragment5", Toast.LENGTH_SHORT).show();
                        mNav.getMenu().findItem(R.id.nav_menu_fragment1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout_NavigationView, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START))
            mDrawer.closeDrawer(GravityCompat.START);
    }
}