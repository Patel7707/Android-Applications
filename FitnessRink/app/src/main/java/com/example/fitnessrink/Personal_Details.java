package com.example.fitnessrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Personal_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);


    }


    public void Home(View view) {
        Intent Home = new Intent(Personal_Details.this,Dashboard.class);
        startActivity(Home);
        finish();
    }
}
