package com.example.preconceptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.preconceptionapp.Util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Registration extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    EditText Username, Password, Email, Phone, Weight;
    ProgressBar Loading;
    Button mLogin,mSignup;



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
        Username=findViewById(R.id.Username);
        Password=findViewById(R.id.Password);
        Email=findViewById(R.id.Email);
        Phone=findViewById(R.id.Phone);
        Weight=findViewById(R.id.Weight);
        Loading=findViewById(R.id.loading);
        mSignup=findViewById(R.id.Signup);

        handler.postDelayed(runnable, 300);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Regist();
            }
        });

    }

    private  void Regist()
    {


        final String username=this.Username.getText().toString().trim();
        final String password=this.Password.getText().toString().trim();
        final String email=this.Email.getText().toString().trim();
        final String phone=this.Phone.getText().toString().trim();
        final String weight=this.Weight.getText().toString().trim();


        if(TextUtils.isEmpty(username)){
            Username.setError("Username is Required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            Password.setError("Password is Required");
            return;
        }
        if(password.length() < 6){
            Password.setError("Password Must be 6 Characters Long");
            return;
        }
        if(TextUtils.isEmpty(email)){
            Email.setError("Email is Required");
            return;
        }
        if(TextUtils.isEmpty(phone)){
            Phone.setError("Phone is Required");
            return;
        }
        if(TextUtils.isEmpty(weight)){
            Weight.setError("Weight is Required");
            return;
        }
        register(username,password,email,phone,weight);
    }

    private void register(final String username, final String password, final String email, final String phone, final String weight) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Loading.setVisibility(View.VISIBLE);
        mSignup.setVisibility(View.GONE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.registerUrl, new Response.Listener<String>() {
            @Override    public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String signup = jsonObject.getString("data");
                    if(signup.equals("success"))
                    {
                        Toast.makeText(Registration.this, "Data Inserted..", Toast.LENGTH_SHORT).show();
                        Intent Login = new Intent(Registration.this,Login.class);
                        startActivity(Login);
                    }
                    else
                    {
                        Toast.makeText(Registration.this, " Data already Exist Enter Valid Data", Toast.LENGTH_SHORT).show();
                        Loading.setVisibility(View.GONE);
                        mLogin.setVisibility(View.VISIBLE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Registration.this, "Error!" +e.getMessage(), Toast.LENGTH_SHORT).show();
                    Loading.setVisibility(View.GONE);
                    mLogin.setVisibility(View.VISIBLE);
                }
                Loading.setVisibility(View.GONE);
                mLogin.setVisibility(View.VISIBLE);




            }
            }, new Response.ErrorListener() {
                @Override    public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Registration.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }) {
                @Override    protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> params = new HashMap<String, String>();

                    params.put("username", username);
                    params.put("password", password);
                    params.put("email", email);
                    params.put("phone", phone);
                    params.put("weight", weight);

                    return params;
                }


            };
        requestQueue.add(stringRequest);


    }


}
