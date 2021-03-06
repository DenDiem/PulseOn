package com.diem.den.pulse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String secondName = intent.getStringExtra("secondName");
       final String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);

        Button bLogout = (Button)  findViewById(R.id.bLogout);
        Button bShowRecipe = (Button) findViewById(R.id.bShowRecipe);
        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        TextView etUsername = (TextView) findViewById(R.id.etUsername);
        TextView etName = (TextView) findViewById(R.id.etName);
        TextView etAge = (TextView) findViewById(R.id.etAge);
        TextView etSecondName = (TextView) findViewById(R.id.etSecondName);
        // Display user details
        String message = "Client: " + name + " " + secondName+ "\nWelcome to u area";

        tvWelcomeMsg.setText(message);
        etUsername.setText(username);
        etSecondName.setText(secondName);
        etName.setText(name);
        etAge.setText(age + "");

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  intent  = new Intent(ClientActivity.this,LoginActivity.class);
                ClientActivity.this.startActivity(intent);
            }
        });
        bShowRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent  = new Intent(ClientActivity.this,ShowRecipeActivity.class);
                intent.putExtra("username", username );
                ClientActivity.this.startActivity(intent);
            }
        });
    }
}
