package com.example.fitnessrink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView = findViewById(R.id.Fitness);
        toolbar = findViewById(R.id.Toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(Dashboard.this);


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
        Intent Profile = new Intent(Dashboard.this, Personal_Details.class);
        startActivity(Profile);
        finish();
    }

    public void Exercise(View view) {
        Intent Profile = new Intent(Dashboard.this, Exercise.class);
        startActivity(Profile);
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();

        if (id == R.id.nav_home)
        {

            Intent  Home = new Intent(Dashboard.this,Dashboard.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_Exercise)
        {

            Intent  Exercise = new Intent(Dashboard.this,Exercise.class);
            startActivity(Exercise);
            finish();
        }
        if (id == R.id.nav_profile)
        {

            Intent  Profile = new Intent(Dashboard.this,Personal_Details.class);
            startActivity(Profile);
            finish();
        }
        return false;


    }
}
