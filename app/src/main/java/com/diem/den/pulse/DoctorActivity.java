package com.diem.den.pulse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Intent intent = getIntent();
        final  String name = intent.getStringExtra("name");
        final String secondName = intent.getStringExtra("secondName");
       final  String username = intent.getStringExtra("username");


        Button bLogout = (Button)  findViewById(R.id.bLogout);
        Button bRecipe = (Button)  findViewById(R.id.bRecipe);

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        TextView etUsername = (TextView) findViewById(R.id.etUsername);
        TextView etName = (TextView) findViewById(R.id.etName);

        TextView etSecondName = (TextView) findViewById(R.id.etSecondName);
        // Display user details
        String message = "Doctor: " + name + " " + secondName+ "\nWelcome to u area";
        tvWelcomeMsg.setText(message);
        etUsername.setText(username);
        etSecondName.setText(secondName);
        etName.setText(name);

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  intent  = new Intent(DoctorActivity.this,LoginActivity.class);


                DoctorActivity.this.startActivity(intent);
            }
        });

        bRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent  = new Intent(DoctorActivity.this,RecipeActivity.class);

                intent.putExtra("doctor", username );
                DoctorActivity.this.startActivity(intent);
            }
        });
    }
}
