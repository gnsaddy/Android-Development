package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "You clicked on Floating Button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void showLinear(View view) {
        Intent intent = new Intent(MainActivity.this, linearLayoutActivity.class);
        startActivity(intent);
    }

    public void showFrame(View view) {
        Intent intent = new Intent(MainActivity.this, frameActivity.class);
        startActivity(intent);
    }

    public void showTabbed(View view) {
        Intent intent = new Intent(MainActivity.this, tabbedLayout.class);
        startActivity(intent);
    }
}
