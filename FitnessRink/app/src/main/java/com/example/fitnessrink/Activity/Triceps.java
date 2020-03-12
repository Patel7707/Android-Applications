package com.example.fitnessrink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessrink.R;

public class Triceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);
    }
    public void Home(View view) {
        Intent Home = new Intent(Triceps.this, Exercise.class);
        startActivity(Home);
    }
}
