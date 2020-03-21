package com.addy.dynamictexteffect;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textInput;
    Button enterButton;
    LinearLayout removeViews;
    RelativeLayout hide;
    Button fontOne, fontTwo, fontThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Dynamic Text Effect");

        textInput = findViewById(R.id.editText);
        enterButton = findViewById(R.id.buttonEnter);
        removeViews = findViewById(R.id.removeViews);
        hide = findViewById(R.id.hideLayout);
        fontOne = findViewById(R.id.fontOne);
        fontTwo = findViewById(R.id.fontTwo);
        fontThree = findViewById(R.id.fontThree);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textInput.getText().toString().isEmpty()){
                    String text = textInput.getText().toString();
                    TextView tv = new TextView(MainActivity.this);
                    tv.setPadding(10, 10, 10, 10);
                    tv.setText(text);
                    tv.setTextSize(25);
                    tv.setTextColor(Color.BLUE);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                    removeViews.addView(tv);
                    hide.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Enter text to continue", Toast.LENGTH_SHORT).show();
                    textInput.setFocusable(true);
                }
            }
        });

        fontOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViews.removeAllViews();
                String text = textInput.getText().toString();
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(25);
                tv.setTextColor(Color.BLACK);
                tv.setGravity(Gravity.CENTER);
                tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                removeViews.addView(tv);
                String styleText = " \n\n TextColor - Green \n";
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setText(styleText);
                item.setTextSize(25);
                item.setTextColor(Color.BLACK);
                item.setGravity(Gravity.CENTER);
                removeViews.addView(item);
            }
        });

        fontTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViews.removeAllViews();
                String text = textInput.getText().toString();
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(25);
                tv.setTextColor(Color.RED);
                tv.setGravity(Gravity.CENTER);
                tv.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                removeViews.addView(tv);
                String styleText = " \n\n TextColor - RED \n";
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setText(styleText);
                item.setTextSize(25);
                item.setTextColor(Color.RED);
                item.setGravity(Gravity.CENTER);
                removeViews.addView(item);
            }
        });

        fontThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViews.removeAllViews();
                String text = textInput.getText().toString();
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(25);
                tv.setTextColor(Color.GRAY);
                tv.setGravity(Gravity.CENTER);
                tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                removeViews.addView(tv);
                String styleText = " \n\n TextColor - GRAY \n";
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setText(styleText);
                item.setTextSize(25);
                item.setTextColor(Color.GRAY);
                item.setGravity(Gravity.CENTER);
                removeViews.addView(item);
            }
        });
    }
}
