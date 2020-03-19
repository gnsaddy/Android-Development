package com.addy.mymenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, pass;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edemail);
        pass = findViewById(R.id.psemail);
        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("aditya123@gmail.com") && pass.getText().toString().equals("aditya123")) {
                    Toast.makeText(MainActivity.this, "Login Done!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menuObj) {
        getMenuInflater().inflate(R.menu.menu, menuObj);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout linearLayout = findViewById(R.id.conslayout);
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(getApplicationContext(), "Switching activity", Toast.LENGTH_LONG).show();
                Intent homeIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.contact:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Contact US").setMessage("Email :- aditya.x510@gmail.com\nPhone :- +91 8271388851").show();
                return true;
            case R.id.cam:
                Intent camIntent = new Intent();
                camIntent.setAction(Settings.ACTION_SOUND_SETTINGS);
                startActivity(camIntent);
                return true;
            case R.id.btnfonts:
                Toast.makeText(getApplicationContext(), "Switching activity", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, buttonActivity.class);
                startActivity(intent);
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }
}
