package com.example.preconceptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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


public class Login extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    EditText Username, Password;
    ProgressBar Loading;
    Button mSignup, mForogt, mLogin;

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
        setContentView(R.layout.activity_login);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);
        mSignup = (Button) findViewById(R.id.signup);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Loading = findViewById(R.id.Loading);
        mForogt = (Button) findViewById(R.id.forgot);
        mLogin = (Button) findViewById(R.id.Login);
        handler.postDelayed(runnable, 2000);


        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
                return;
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();

            }
        });


    }

    private void Login() {

        final String username = this.Username.getText().toString().trim();
        final String password = this.Password.getText().toString().trim();
        login(username, password);
    }

    private void login(final String username, final String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Loading.setVisibility(View.VISIBLE);
        mLogin.setVisibility(View.GONE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String login = jsonObject.getString("data");
                    if (login.equals("success")) {
                        Toast.makeText(Login.this, "Login Successful! Welcome User", Toast.LENGTH_SHORT).show();
                        Intent Login = new Intent(Login.this, Home_Page.class);
                        startActivity(Login);
                    } else {
                        Toast.makeText(Login.this, "Login  Unsuccessful", Toast.LENGTH_SHORT).show();
                        Loading.setVisibility(View.GONE);
                        mLogin.setVisibility(View.VISIBLE);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Login.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Loading.setVisibility(View.GONE);
                    mLogin.setVisibility(View.VISIBLE);
                }
                Loading.setVisibility(View.GONE);
                mLogin.setVisibility(View.VISIBLE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("username", username);
                params.put("password", password);
                return params;
            }


        };
        requestQueue.add(stringRequest);
    }


}


