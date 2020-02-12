package com.addy.runtimeviewtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new CustomView(this));
        ImageView imageView = new ImageView(this);

    }

    public class CustomView extends View{
        final Paint paint = new Paint();

        public CustomView(Context context) {
            super(context);
            paint.setTextSize(70);
            paint.setColor(Color.GRAY);
            this.setBackgroundColor(Color.BLACK);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawText("Run time custom view",300,400,paint);
//            canvas.drawPicture();
            invalidate();
        }
    }
}
