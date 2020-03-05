package com.example.preconceptionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class Walking extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    TextView Weekly1;
    NavigationView navigationView;
    Toolbar toolbar;
    LineChartView LineChart;
    String[] XData = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    int[] YData = {5206, 2500, 8500, 3000, 10000, 6000, 4000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        Weekly1=findViewById(R.id.WeeklyReport);
        LineChart = findViewById(R.id.chart);

        drawerLayout = findViewById(R.id.walk1);
        navigationView = findViewById(R.id.walk2);
        toolbar = findViewById(R.id.walk3);


        List Y = new ArrayList();
        List X = new ArrayList();






        //change the color of line chart
        Line Line = new Line(Y).setColor(Color.parseColor("#19AA8B"));

        //add Axis and Y-Axis data inside yAxisValues and axisValues lists
        for(int i = 0; i <XData.length; i++){
            X.add(i, new AxisValue(i).setLabel(XData[i]));
        }

        for (int i = 0; i < YData.length; i++){
            Y.add(new PointValue(i, YData[i]));
        }

        //Declare a list of a type Line
        List lines = new ArrayList();
        lines.add(Line);

        // add the graph line to the overall data chart
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //able to see the Android line chart
        LineChart.setLineChartData(data);


        //X-Axis values
        Axis axis = new Axis();
        axis.setValues(X);
        data.setAxisXBottom(axis);

        // Y-Axis values
        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);



        //text size of the Axis data
        axis.setTextSize(14);

        //change the text color to any color
        axis.setTextColor(Color.parseColor("#050004"));

        //text size and color for Y-Axis data
        yAxis.setTextColor(Color.parseColor("#050004"));
        yAxis.setTextSize(14);

        //Add a label
        yAxis.setName("Step Counter");
        axis.setName("Monthly");

        // Y-Axis data inside the line chart
        Viewport viewport = new Viewport(LineChart.getMaximumViewport());
        viewport.top =10000;
        LineChart.setMaximumViewport(viewport);
        LineChart.setCurrentViewport(viewport);

        // Toolbar
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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();

        if (id == R.id.nav_home)
        {

            Intent Home = new Intent(Walking.this,Home_Page.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_weekly)
        {

            Intent  Home = new Intent(Walking.this,Weekly_Report.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_monthly)
        {

            Intent  Home = new Intent(Walking.this,Monthly_Report.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_walk)
        {

            Intent  Home = new Intent(Walking.this,Walking.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_meal)
        {

            Intent  Home = new Intent(Walking.this,Meal.class);
            startActivity(Home);
            finish();
        }
        if (id == R.id.nav_profile)
        {

            Intent  Home = new Intent(Walking.this,Profile.class);
            startActivity(Home);
            finish();
        }
        return false;
    }

}
