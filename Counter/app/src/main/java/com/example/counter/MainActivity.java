package com.example.counter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mCount;
    ConstraintLayout Click;
    int count;
    Button History,Reset;
    SharedPreferences sharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        History =findViewById(R.id.hh);
        Reset=findViewById(R.id.Reset);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                mCount.setText("" + count);
            }
        });

        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent History = new Intent(MainActivity.this,History.class);
                startActivity(History);

            }
        });


    }





    public void Button(View view) {

        defineValues();
        loadValues();
        setCount();
        buttonHandler();


    }

    public void defineValues() {
        mCount = findViewById(R.id.Count);
        Click = findViewById(R.id.Counter);
        sharedPreferences = getSharedPreferences("count", Context.MODE_PRIVATE);

    }
    public void loadValues() {
        sharedPreferences = getSharedPreferences("count", Context.MODE_PRIVATE);
    }
    private void setCount() {
        count = sharedPreferences.getInt("count", 0);
        if (count == 0) {
            mCount.setText("count");

        } else {
            mCount.setText(Integer.toString(count));

        }

    }
    public void buttonHandler() {
        Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count != 0) {
                    count = sharedPreferences.getInt("count", 0);
                    count += 1;
                    mCount.setText(Integer.toString(count));
                } else {
                    count += 1;
                    mCount.setText(Integer.toString(count));
                }
                commitToSharedPreferences();
            }
        });
    }
    public void commitToSharedPreferences() {
        sharedPreferences.edit().putInt("count", count).apply();
    }



}
