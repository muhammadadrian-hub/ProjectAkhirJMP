package com.example.projectakhirjmp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectakhirjmp.R;

public class Login extends AppCompatActivity {

    //variable data
    EditText txtUsernamelg, txtPasswordlg;
    Button btnLogin, btnRegister;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //deklarsi variabel

        txtUsernamelg = (EditText) findViewById(R.id.txtUser);
        txtPasswordlg = (EditText) findViewById(R.id.txtPw);
        btnLogin = (Button) findViewById(R.id.btnlgn);
        btnRegister = (Button) findViewById(R.id.btnrgst);
        dblogin = new DatabaseHelper(this);

        //memulai program
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamelg = txtUsernamelg.getText().toString();
                String passwordlg = txtPasswordlg.getText().toString();
                Boolean checkUserPassword = dblogin.checkUserPassword(usernamelg, passwordlg);
                if (checkUserPassword) {
                    Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}