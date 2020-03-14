package com.example.preconceptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Water extends AppCompatActivity {

    TextView Water1, Water2;
    EditText Water3;
    Button Water4,Water6;
    RadioGroup Water5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        Water1 = findViewById(R.id.water7);
        Water2 = findViewById(R.id.water10);
        Water3 = findViewById(R.id.water8);
        Water4 = findViewById(R.id.water9);
        Water5 = findViewById(R.id.group);
        Water6=findViewById(R.id.water11);

        Water5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);

            }


        });
        Water6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = Water5.getCheckedRadioButtonId();
                if (selectedId == -1) {

                    Water1.setVisibility(View.INVISIBLE);
                    Water3.setVisibility(View.INVISIBLE);
                    Water2.setVisibility(View.VISIBLE);


                }
                else {

                    RadioButton radioButton
                            = (RadioButton)Water5
                            .findViewById(selectedId);

                    // Now display the value of selected item
                    // by the Toast message
                    Water1.setVisibility(View.VISIBLE);
                    Water3.setVisibility(View.VISIBLE);
                    Water4.setVisibility(View.VISIBLE);

                }
            }
        });


    }
}
