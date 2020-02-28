package com.example.preconceptionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;

public class Meal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        drawerLayout = findViewById(R.id.meal1);
        navigationView = findViewById(R.id.meal2);
        toolbar = findViewById(R.id.meal3);

        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        //Spinner
        Spinner Months = findViewById(R.id.months);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Months,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Months.setAdapter(adapter);



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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();

        if (id == R.id.nav_home)
        {

            Intent Home = new Intent(Meal.this,Home_Page.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_weekly)
        {

            Intent  Home = new Intent(Meal.this,Weekly_Report.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_monthly)
        {

            Intent  Home = new Intent(Meal.this,Monthly_Report.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_walk)
        {

            Intent  Home = new Intent(Meal.this,Walking.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_meal)
        {

            Intent  Home = new Intent(Meal.this,Meal.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_profile)
        {

            Intent  Home = new Intent(Meal.this,Profile.class);
            startActivity(Home);
            finish();
        }
        return false;
    }

}
