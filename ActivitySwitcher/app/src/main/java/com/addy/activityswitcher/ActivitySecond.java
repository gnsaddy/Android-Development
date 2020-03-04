package com.addy.activityswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {
    ImageButton btn1, btn2;
    TextView tv;
    EditText res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn1 = findViewById(R.id.imageButton);
        btn2 = findViewById(R.id.imageButton2);
        tv = findViewById(R.id.textView);
        res = findViewById(R.id.textView2);

        if(getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)){
            tv.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = res.getText().toString();
                Intent intent = new Intent(ActivitySecond.this, MainActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,result);
                startActivity(intent);
            }
        });


    }
}
