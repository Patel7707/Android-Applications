package com.example.preconceptionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;

public class Home_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.pre);
        toolbar = findViewById(R.id.Toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);



    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {

            super.onBackPressed();
        }
    }

    public void Profile(View view) {
        Intent Profile=new Intent(this,Profile.class);
        startActivity(Profile);
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();

        if (id == R.id.nav_home)
        {

            Intent  Home = new Intent(Home_Page.this,Home_Page.class);
            startActivity(Home);

        }
        if (id == R.id.nav_weekly)
        {

            Intent  Weekly = new Intent(Home_Page.this,Weekly_Report.class);
            startActivity(Weekly);

        }
        if (id == R.id.nav_monthly)
        {

            Intent  Monthly = new Intent(Home_Page.this,Monthly_Report.class);
            startActivity(Monthly);

        }
        if (id == R.id.nav_walk)
        {

            Intent  Walk = new Intent(Home_Page.this,Walking.class);
            startActivity(Walk);

        }
        if (id == R.id.nav_meal)
        {

            Intent  Meal = new Intent(Home_Page.this,Meal.class);
            startActivity(Meal);

        }
        if (id == R.id.nav_profile)
        {

            Intent  Profile = new Intent(Home_Page.this,Profile.class);
            startActivity(Profile);

        }
        return false;
    }

    public void Walking(View view) {
        Intent  Walking = new Intent(Home_Page.this,Walking.class);
        startActivity(Walking);

    }

    public void Meal(View view) {
        Intent  Meal = new Intent(Home_Page.this,Meal.class);
        startActivity(Meal);

    }

    public void Water(View view) {
        Intent  Water = new Intent(Home_Page.this,Water.class);
        startActivity(Water);
    }
}
