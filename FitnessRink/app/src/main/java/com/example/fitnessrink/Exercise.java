package com.example.fitnessrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Exercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    public void Home(View view) {
        Intent Home = new Intent(Exercise.this,Dashboard.class);
        startActivity(Home);
        finish();
    }
}
