package com.addy.progressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Work in progress");
                pd.setCancelable(false);
                pd.show();

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        pd.dismiss();
                    }
                }, 3000);
            }
        });
    }
}
