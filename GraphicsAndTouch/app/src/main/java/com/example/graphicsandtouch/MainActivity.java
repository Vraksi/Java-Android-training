package com.example.graphicsandtouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyGraphic g = new MyGraphic(this);
        LinearLayout layout = findViewById(R.id.layout);
        layout.addView(g);
        Thread t = new Thread(g);
        t.start();


    }
}