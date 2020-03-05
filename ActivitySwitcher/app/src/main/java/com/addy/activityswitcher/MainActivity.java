package com.addy.activityswitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btn,btnSend;
    EditText et1;
    TextView v;
    public static final String REQUEST_RESULT = "REQUEST_RESULT";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Toast.makeText(MainActivity.this,Integer.toString(data.getIntExtra(REQUEST_RESULT,0)),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.imageBtn1);
        et1 = findViewById(R.id.editText);
        btnSend =findViewById(R.id.imageBtn);
        v = findViewById(R.id.textView2);

        if(getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)){
            v.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et1.getText().toString();
                Intent intent = new Intent(MainActivity.this,ActivitySecond.class);
                intent.putExtra(intent.EXTRA_TEXT,text);
                startActivityForResult(intent,1);
            }
        });



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et1.getText().toString();
                Intent intent = new Intent(MainActivity.this,ActivitySecond.class);
                intent.putExtra(intent.EXTRA_TEXT,text);
                startActivity(intent);
            }
        });
    }
}
