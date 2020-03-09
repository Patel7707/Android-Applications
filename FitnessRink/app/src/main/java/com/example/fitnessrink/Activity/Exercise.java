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
    }

    public void Glutes(View view) {
    }

    public void Hamstrings(View view) {
    }

    public void Lats(View view) {
    }

    public void Middle_Back(View view) {
    }

    public void Lower_Back(View view) {
    }

    public void Neck(View view) {
    }

    public void Quads(View view) {
    }

    public void Shoulders(View view) {
    }

    public void Traps(View view) {
    }

    public void Triceps(View view) {
    }
}
