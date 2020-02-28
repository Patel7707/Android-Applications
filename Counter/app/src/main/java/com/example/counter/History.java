package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView mCount;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);




        mCount=findViewById(R.id.counter);
        loadValues();
        setCount();




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

}
