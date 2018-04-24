package com.example.admin.amarpushp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    Toolbar toolbar;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        fragmentManager = getSupportFragmentManager();
    toolbar = (Toolbar) findViewById(R.id.toolbar);
        setbottomnavigator(savedInstanceState);
        setSupportActionBar(toolbar);
      setDrawer();
       setNavigationView();

    }

    private void setbottomnavigator(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Fragment home_frag = new HomeFrag();
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_Frame, home_frag).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.ic_home:
                        fragment = new HomeFrag();
                        break;
                    case R.id.key_projects:
                        fragment = new KeyProjects_Frag();
                        break;
                    case R.id.career:
                        fragment = new Career();
                        break;
                    case R.id.donate:
                        fragment = new DonateFrag();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_Frame, fragment).commit();
                return true;
            }
        });
    }
    private void setDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
        if (drawerLayout != null && toolbar != null) {
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.close, R.string.close) {

            };
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
        }
    }

    private void setNavigationView() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.ic_home:
                        fragment = new HomeFrag();
                        final FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.main_Frame, fragment).commit();
                        break;
                    case R.id.about_org:
                        Intent in1 = new Intent(getApplicationContext(), About_Organisation.class);
                        startActivity(in1);
                        break;
                    case R.id.gallery:
                        Intent in2 = new Intent(getApplicationContext(), Gallery.class);
                        startActivity(in2);
                        break;
                    case R.id.videos:
                        Intent in3 = new Intent(getApplicationContext(), Gallery.class);
                        startActivity(in3);
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}