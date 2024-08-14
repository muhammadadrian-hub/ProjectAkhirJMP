package com.example.projectakhirjmp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectakhirjmp.R;

import org.w3c.dom.Text;

public class kalkulator extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;
    Button button, button2, button3, button4, button5;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
        editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        textView3 = (TextView) findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextNumber1.getText().length()>0) && (editTextNumber2.getText().length()>0)) {
                    double angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                    double angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                    double result = angka1 + angka2;
                    textView3.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(kalkulator.this, "Mohon masukkan angka pertama dan kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextNumber1.getText().length()>0) && (editTextNumber2.getText().length()>0)) {
                    double angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                    double angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                    double result = angka1 - angka2;
                    textView3.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(kalkulator.this, "Mohon masukkan angka pertama dan kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextNumber1.getText().length()>0) && (editTextNumber2.getText().length()>0)) {
                    double angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                    double angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                    double result = angka1 / angka2;
                    textView3.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(kalkulator.this, "Mohon masukkan angka pertama dan kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editTextNumber1.getText().length()>0) && (editTextNumber2.getText().length()>0)) {
                    double angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                    double angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                    double result = angka1 * angka2;
                    textView3.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(kalkulator.this, "Mohon masukkan angka pertama dan kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumber1.setText("");
                editTextNumber2.setText("");
                textView3.setText("0");
                editTextNumber1.requestFocus();
            }
        });
    }
}