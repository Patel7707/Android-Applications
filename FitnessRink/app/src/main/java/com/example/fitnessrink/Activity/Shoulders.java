package com.example.fitnessrink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessrink.R;

public class Shoulders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders);
    }
    public void Home(View view) {
        Intent Home = new Intent(Shoulders.this, Exercise.class);
        startActivity(Home);
    }
}
