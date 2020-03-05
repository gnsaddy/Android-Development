package com.addy.runtimewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.llayout);
        ll = new LinearLayout(this);
        DatePicker datePicker = new DatePicker(this);
        ll.addView(datePicker);
        Button btn = new Button(this);
        btn.setText("Test");
        ll.addView(btn);
        setContentView(ll);
    }
}
