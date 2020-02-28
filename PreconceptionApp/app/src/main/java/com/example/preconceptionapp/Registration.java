package com.example.preconceptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RelativeLayout;



public class Registration extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    EditText Username, Password, Email, Phone, Weight;
    Button mLogin;


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        rellay1 = (RelativeLayout) findViewById(R.id.relay1);
        rellay2 = (RelativeLayout) findViewById(R.id.relay2);
        mLogin = (Button) findViewById(R.id.login);

        handler.postDelayed(runnable, 300);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

    }


}
