package com.example.easylearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText emailid,password;
    Button btnSignin;
    TextView tvsignup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailid=findViewById(R.id.edt_email);
        password=findViewById(R.id.edt_password);
        btnSignin=findViewById(R.id.btn_signIn);
        tvsignup=findViewById(R.id.txt_view);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser= mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null){
                    Toast.makeText(LoginActivity.this,"You are Logged In",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Please Login ",Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= emailid.getText().toString();
                String pwd=password.getText().toString();
                if(email.isEmpty()){
                    emailid.setError("Please Enter your Email Address");
                    emailid.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Please Enter your Password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Field are Empty!",Toast.LENGTH_SHORT);
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if(! task.isSuccessful()){
                              Toast.makeText(LoginActivity.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT);
                          }
                          else{
                              Intent intToHome = new Intent(LoginActivity.this,HomeActivity.class);
                              startActivity(intToHome);
                          }
                        }
                    });
                }
                else {
                    Toast.makeText(LoginActivity.this,"Error Ocurred!",Toast.LENGTH_SHORT);
                }
            }
        });

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp= new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intSignUp);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
