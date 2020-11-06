package com.example.app_afslutning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView petName;
    Button getPetName, getPetColor;
    Intent intent;
    String petType;
    final int REQ_GET_NAME = 0;
    final int REQ_GET_COLOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        petName = findViewById(R.id.petName);
        getPetName = findViewById(R.id.getPetName);
        getPetColor = findViewById(R.id.getPetColor);

        getPetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SetPetName.class);
                startActivityForResult(intent, REQ_GET_NAME);
            }
        });

        getPetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, PickColor.class);
                intent.putExtra("type", petType);
                startActivityForResult(intent, REQ_GET_COLOR);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_GET_NAME){
            petType = data.getStringExtra("type");
            String format = String.format("%s: %s", data.getStringExtra("type"), data.getStringExtra("name"));
            petName.setText(format);
        }
        if (requestCode == REQ_GET_COLOR ){
            String combined = data.getStringExtra("color");
            int colorInt = Integer.parseInt(combined, 16);
            colorInt += 0xFF000000;
            petName.setBackgroundColor(colorInt);
        }
    }
}