package com.example.fitnessrink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessrink.R;

public class Lats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lats);
    }

    public void Home(View view) {
        Intent Home = new Intent(Lats.this, Exercise.class);
        startActivity(Home);
    }
}
