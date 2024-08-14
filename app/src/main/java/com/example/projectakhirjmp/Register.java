
package com.example.projectakhirjmp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button btnregister;
    EditText eduser,edpass;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister = findViewById(R.id.btnrgst);
        eduser = findViewById(R.id.textView6);
        edpass = findViewById(R.id.textView7);
        dblogin = new DatabaseHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = eduser.getText().toString();
                String password = edpass.getText().toString();
                Boolean checkUser = dblogin.checkUser(user);
                if (checkUser == false) {
                    Boolean insert = dblogin.insertUser(user, password);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "User Already Exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}