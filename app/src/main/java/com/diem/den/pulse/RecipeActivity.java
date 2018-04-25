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

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Intent intent = getIntent();
        final String doctor = intent.getStringExtra("doctor");
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etMedicine = (EditText) findViewById(R.id.etMedicine);
        final EditText etInstruction = (EditText) findViewById(R.id.etInstruction);
        final EditText etTime = (EditText) findViewById(R.id.etTime);

        final Button bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String medicine = etMedicine.getText().toString();
                final String instruction = etInstruction.getText().toString();
                final String time = etTime.getText().toString();

                Response.Listener<String> stringListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RecipeActivity.this);
                                builder.setMessage("Recipe add success")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RecipeActivity.this);
                                builder.setMessage("Recipe add fail").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RecipeRequestout registerRequest = new RecipeRequestout(username, doctor, medicine, instruction, time, stringListener);
                RequestQueue queue = Volley.newRequestQueue(RecipeActivity.this);
                queue.add(registerRequest);


            }
        });
    }
}
