package com.example.user.navigationproject;

import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
//import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nav_view;
   // BottomNavigationView Bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       dl = (DrawerLayout)findViewById(R.id.dl);
        t = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);



        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Bottom_nav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        Bottom_nav.setOnNavigationItemSelectedListener(navListener);*/

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        nav_view= (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.myprofile) {
                    Toast.makeText(MainActivity.this, "MyProfile", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.settings) {
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.editprofile) {
                    Toast.makeText(MainActivity.this, "EditProfile", Toast.LENGTH_SHORT).show();
                }
                return false;

            }
        });
    }

    /*private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()) {

                        case R.id.home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.favourite:
                            selectedFragment = new FavoritesFragment();
                            break;
                        case R.id.search:
                            selectedFragment = new SearchFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

                    return true;
                }

    };*/

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);


    }
}
