package com.diem.den.pulse;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
private static final String secretWord = "kma2020";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etUsername =  (EditText) findViewById(R.id.etUsername);
        final EditText etPassword =  (EditText) findViewById(R.id.etPassword);
        final EditText etName =  (EditText) findViewById(R.id.etName);
        final EditText etSecondName =  (EditText) findViewById(R.id.etSecondName);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final Button  bRegister = (Button) findViewById(R.id.bRegister);
        final EditText doc =  (EditText) findViewById(R.id.etDoc);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String username =etUsername.getText().toString();
                final String name =etName.getText().toString();
                final String secondName =etSecondName.getText().toString();
                final String password =etPassword.getText().toString();
                final int age =Integer.parseInt(etAge.getText().toString());
                final String sW = doc.getText().toString();
                Response.Listener<String> stringListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Regiser fail").setNegativeButton("Retry",null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                };
                if (sW.equals(secretWord)){
                    RegisterRequest registerRequest = new RegisterRequest(name,secondName,age,username,password,1,stringListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                }else{
                    RegisterRequest registerRequest = new RegisterRequest(name,secondName,age,username,password,0,stringListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                }


            }
        });
    }


}
