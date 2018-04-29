package com.diem.den.pulse;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipe);
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");

                Response.Listener<String> stringListener = new Response.Listener<String>() {
                    @SuppressLint("NewApi")
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jArr = new JSONArray(response);
                           // boolean success = jsonObject.getBoolean("success");
                            int i=0;
                            JSONObject  part =  jArr.optJSONObject(i++);
                            LinearLayout layout = (LinearLayout) findViewById(R.id.scbr);

                            while(part!=null){



                                TextView newTV = new TextView(getApplicationContext());
                                newTV.setText("                 MESSAGE:\nUsername: "+part.getString("username") +"\nDoctor: " +part.getString("doctor")  + "\nMedicine: " +part.getString("medicine") + "\nInstruction: " +part.getString("instruction") +"\nTime: " +part.getString("time") );
                                newTV.setTextColor(Color.rgb(198,76,255));

                                newTV.setBackground(getDrawable(R.drawable.border));
                                newTV.setPadding(30,5,5,5);
                                /**** Any other text view setup code ****/
                                layout.addView(newTV);


                                  part =  jArr.optJSONObject(i++);

                            }


                            if(i==0) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ShowRecipeActivity.this);
                                builder.setMessage("no Recipe for u").setNegativeButton("thank for waiting", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RecipeRequestIn registerRequest = new RecipeRequestIn(username,  stringListener);
                RequestQueue queue = Volley.newRequestQueue(ShowRecipeActivity.this);
                queue.add(registerRequest);


            }
    }

