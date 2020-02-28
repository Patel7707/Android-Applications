package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity
{       EditText edt1,edt2;
        Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt1=findViewById(R.id.edt_emailid);
        edt2=findViewById(R.id.edt_password);
        btn1=findViewById(R.id.btn_Login);



    }
}
