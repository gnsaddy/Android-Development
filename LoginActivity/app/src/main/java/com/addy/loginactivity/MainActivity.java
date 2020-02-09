package com.addy.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, pt1;
    Button btn1;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
//        btn2 = findViewById(R.id.button2);
        et1 = findViewById(R.id.loginInput);
        pt1 = findViewById(R.id.passwordInput);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et1.getText().toString().equals("aditya123@gmail.com") && pt1.getText().toString().equals("aditya123")) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                } else {
                    count++;
                    Toast.makeText(getApplicationContext(), "Invalid usename and password", Toast.LENGTH_SHORT).show();
                    if (count == 3) {
                        btn1.setEnabled(false);
                        new CountDownTimer(1000, 100) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }
                            @Override
                            public void onFinish() {
                                btn1.setEnabled(true);
                            }
                        }.start();
                    }
                }
            }
        });

    }
}