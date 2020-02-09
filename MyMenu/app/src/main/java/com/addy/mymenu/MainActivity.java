package com.addy.mymenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menuObj) {
        getMenuInflater().inflate(R.menu.menu, menuObj);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        ConstraintLayout constraintLayout = findViewById(R.id.conslayout);
        switch (item.getItemId()) {
            case R.id.red:
                constraintLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.blue:
                constraintLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.green:
                constraintLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.grey:
                constraintLayout.setBackgroundColor(Color.GRAY);
                return true;
            case R.id.black:
                constraintLayout.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.btnfonts:
                Toast.makeText(getApplicationContext(), "Switching activity", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,buttonActivity.class);
                startActivity(intent);
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }
}
