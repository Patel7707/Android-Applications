package com.example.fitnessrink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessrink.R;

public class Exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    public void Home(View view) {
        Intent Home = new Intent(Exercise.this, Dashboard.class);
        startActivity(Home);

    }

    public void Abs(View view) {
        Intent Home = new Intent(Exercise.this, Abs.class);
        startActivity(Home);

    }

    public void Biceps(View view) {
        Intent Home = new Intent(Exercise.this, Biceps.class);
        startActivity(Home);

    }

    public void Calves(View view) {
        Intent Home = new Intent(Exercise.this, Calves.class);
        startActivity(Home);
    }

    public void Forearm(View view) {
        Intent Home = new Intent(Exercise.this, ForeArm.class);
        startActivity(Home);
    }

    public void Glutes(View view) {
        Intent Home = new Intent(Exercise.this, Glute.class);
        startActivity(Home);
    }

    public void Hamstrings(View view) {
        Intent Home = new Intent(Exercise.this, Hamstrings.class);
        startActivity(Home);
    }

    public void Lats(View view) {
        Intent Home = new Intent(Exercise.this, Lats.class);
        startActivity(Home);
    }

    public void Middle_Back(View view) {
        Intent Home = new Intent(Exercise.this, Middle_Back.class);
        startActivity(Home);
    }

    public void Lower_Back(View view) {
        Intent Home = new Intent(Exercise.this, Lower_Back.class);
        startActivity(Home);
    }

    public void Neck(View view) {
        Intent Home = new Intent(Exercise.this, Neck.class);
        startActivity(Home);
    }

    public void Quads(View view) {
        Intent Home = new Intent(Exercise.this, Quads.class);
        startActivity(Home);
    }

    public void Shoulders(View view) {
        Intent Home = new Intent(Exercise.this, Shoulders.class);
        startActivity(Home);
    }

    public void Traps(View view) {
        Intent Home = new Intent(Exercise.this, Traps.class);
        startActivity(Home);
    }

    public void Triceps(View view) {
        Intent Home = new Intent(Exercise.this, Triceps.class);
        startActivity(Home);
    }
}
