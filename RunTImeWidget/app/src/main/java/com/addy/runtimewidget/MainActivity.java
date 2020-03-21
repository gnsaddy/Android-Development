package com.addy.runtimewidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    Button btnDr,btnIn;
    CircleImageView imageView;
    ConstraintLayout cl;
    String url1 = "https://cdn.pixabay.com/photo/2016/09/25/15/11/android-1693894_1280.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDr = findViewById(R.id.btnDrawable);
        btnIn = findViewById(R.id.btnInternet);
        imageView = findViewById(R.id.loadImg);
        cl = findViewById(R.id.clayout);

        btnDr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.setVisibility(View.VISIBLE);
                Picasso.get().load(R.drawable.mirageupgrade).into(imageView);
            }
        });

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.setVisibility(View.VISIBLE);
                Picasso.get().load(url1).into(imageView);
            }
        });
    }
}
