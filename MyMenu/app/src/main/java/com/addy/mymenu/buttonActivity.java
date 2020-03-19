package com.addy.mymenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class buttonActivity extends AppCompatActivity {
//    String JSON_STRING = "{\"user\":{\"email\":\"aditya1234@gmail.com\",\"password\":12345}}";
//    String email, password;
    EditText name, pass, conpass;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        name = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        conpass = findViewById(R.id.conpass);
        imageButton = findViewById(R.id.create);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass.getText().toString().equals(conpass.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Account created!!", Toast.LENGTH_LONG).show();
                    JSONArray jArr = new JSONArray();
                    JSONObject jObj = new JSONObject();
                    try {
                        jObj.put("email", name.getText().toString());
                        jObj.put("password ", pass.getText().toString());
                        jArr.put(jObj);

                    } catch (Exception e) {
                        System.out.println("Error:" + e);
                    }
                    System.out.println(jArr);
                } else {
                    Toast.makeText(getApplicationContext(), "Confirm password not match!!", Toast.LENGTH_LONG).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(buttonActivity.this);
                builder.setTitle("Contact US").setMessage("Email :- aditya.x510@gmail.com\nPhone :- +91 8271388851").show();
                return true;
            case R.id.cam:
                Intent camIntent = new Intent();
                camIntent.setAction(Settings.ACTION_SOUND_SETTINGS);
                startActivity(camIntent);
                return true;
            case R.id.btnfonts:
                Toast.makeText(getApplicationContext(), "Switching activity", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),buttonActivity.class);
                startActivity(intent);
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }
}
