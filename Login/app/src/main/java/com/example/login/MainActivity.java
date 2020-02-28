package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity
{
    TextView txt1;
    EditText edt1,edt2,edt3,edt4;
    CheckBox chk1,chk2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=findViewById(R.id.txt_welcome);
        edt1=findViewById(R.id.edt_firstname);
        edt2=findViewById(R.id.edt_lastname);
        edt3=findViewById(R.id.edt_emailid);
        edt4=findViewById(R.id.edt_password);
        chk1=findViewById(R.id.chk_male);
        chk2=findViewById(R.id.chk_female);
        btn1=findViewById(R.id.btn_Register);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            { String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                    "\\@" +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                    "(" +

                    "\\." +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                    ")+";

                String email= edt3.getText().toString();

                Matcher matcher= Pattern.compile(validemail).matcher(email);
                if(matcher.matches())
                {
                    Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_LONG).show();
                }
                else
                {
                    edt3.setError("Enter Valid Email ID");
                }

                Intent I=new Intent(MainActivity.this,Login.class);
                startActivity(I);
            }
        });

    }

    public void onCheckboxClicked(View view) {
        switch(view.getId()) {

        }
        boolean checked = ((CheckBox) view).isChecked();
        case R.id.chk_male:
                if (checked)
                {
                    Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                }
                else
                    break;
            case R.id.chk_female:
                if (checked)
                {
                    Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                }
                else
                break;
    }
}
