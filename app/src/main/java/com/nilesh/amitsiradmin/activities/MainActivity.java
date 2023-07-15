package com.nilesh.amitsiradmin.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nilesh.amitsiradmin.R;
import com.nilesh.amitsiradmin.fragments.GameFragment;
import com.nilesh.amitsiradmin.fragments.HomeFragment;
import com.nilesh.amitsiradmin.fragments.RingFragment;
import com.nilesh.amitsiradmin.fragments.WallFragment;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.main_drawer);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation menu item clicks here
                selectDrawerItem(item);
                return true;
            }
        });

        // Set the initial fragment when the activity starts
        Fragment initialFragment = new HomeFragment();
        replaceFragment(initialFragment);
    }

    private void selectDrawerItem(MenuItem item) {
        // Create a new fragment based on the selected item
        Fragment fragment = null;

        if (item.getItemId()==R.id.side_home){
            fragment = new HomeFragment();
        }else if (item.getItemId()==R.id.side_wall){
            fragment = new WallFragment();
        }else if (item.getItemId()==R.id.side_ring){
            fragment = new RingFragment();
        }else if (item.getItemId()==R.id.side_game){
            fragment = new GameFragment();
        }

//        switch (item.getItemId()==R.id.side_home) {
//            case R.id.side_home:
//                fragment = new HomeFragment();
//                break;
//            case R.id.side_wall:
//                fragment = new WallFragment();
//                break;
//            case R.id.side_ring:
//                fragment = new RingFragment();
//                break;
//        }

        if (fragment != null) {
            replaceFragment(fragment);
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            drawerLayout.closeDrawers();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}