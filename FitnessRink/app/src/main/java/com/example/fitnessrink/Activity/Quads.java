package com.example.fitnessrink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessrink.R;

public class Quads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quads);
    }
    public void Home(View view) {
        Intent Home = new Intent(Quads.this, Exercise.class);
        startActivity(Home);
    }
}
