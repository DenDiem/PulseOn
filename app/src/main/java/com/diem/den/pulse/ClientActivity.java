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
        String name = intent.getStringExtra("name");
        String secondName = intent.getStringExtra("secondName");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);

        Button bLogout = (Button)  findViewById(R.id.bLogout);

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etAge = (EditText) findViewById(R.id.etAge);
        EditText etSecondName = (EditText) findViewById(R.id.etSecondName);
        // Display user details
        String message = "Client: " + "/n" + "Welcome to u area";
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
    }
}
