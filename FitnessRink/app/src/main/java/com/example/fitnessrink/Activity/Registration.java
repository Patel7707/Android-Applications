package com.example.fitnessrink.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fitnessrink.R;
import com.example.fitnessrink.Utils.Contants;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    TextInputLayout Name, Username, Password, Email, Phone;
    RadioGroup Gender;
    Button Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        Name = findViewById(R.id.reg_name);
        Username = findViewById(R.id.reg_username);
        Password = findViewById(R.id.reg_password);
        Email = findViewById(R.id.reg_email);
        Phone = findViewById(R.id.reg_phone);
        Gender = findViewById(R.id.group);
        Register = findViewById(R.id.reg_signup);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();

            }

        });

        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton
                        radioButton
                        = (RadioButton) group
                        .findViewById(checkedId);
            }
        });
    }

    private void Regist() {
        int selectedId = Gender.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(Registration.this,
                    "No answer has been selected",
                    Toast.LENGTH_SHORT)
                    .show();
        } else {

            RadioButton radioButton
                    = (RadioButton) Gender
                    .findViewById(selectedId);

            // Now display the value of selected item
            // by the Toast message
            Toast.makeText(Registration.this,
                    radioButton.getText(),
                    Toast.LENGTH_SHORT)
                    .show();
        }
        final String Name = Registration.this.Name.getEditText().getText().toString().trim();
        final String Username = Registration.this.Username.getEditText().getText().toString().trim();
        final String Password = Registration.this.Password.getEditText().getText().toString().trim();
        final String Email = Registration.this.Email.getEditText().getText().toString().trim();
        final String Phone = Registration.this.Phone.getEditText().getText().toString().trim();
        final String Gender = Registration.this.Gender.toString().trim();

        register(Name,Username,Password,Email,Phone,Gender);



    }

    private void register(final String name, final String username, final String password, final String email, final String phone, final String gender) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Contants.registerUrl, new Response.Listener<String>() {
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

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Registration.this, "Error!" +e.getMessage(), Toast.LENGTH_SHORT).show();

                }





            }
        }, new Response.ErrorListener() {
            @Override    public void onErrorResponse(VolleyError error) {

                Toast.makeText(Registration.this, "Error", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override    protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                params.put("name", name);
                params.put("username", username);
                params.put("password", password);
                params.put("email", email);
                params.put("phone", phone);
                params.put("gender", gender);

                return params;
            }


        };
        requestQueue.add(stringRequest);




    }


}
