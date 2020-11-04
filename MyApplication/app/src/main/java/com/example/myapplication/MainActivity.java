package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name, lastName;
    Button btn, btnRadio;
    Intent intent;
    final int REQ_Get_Info = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        lastName = findViewById(R.id.lastName);
        btn = findViewById(R.id.btn);
        btnRadio = findViewById(R.id.btnRadio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Info.class);
                startActivityForResult(intent, REQ_Get_Info);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, RadioButton.class);
                startActivityForResult(intent, REQ_Get_Info);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_Get_Info && resultCode == resultCode)
        {
            name.setText(data.getStringExtra("navn"));
            lastName.setText(data.getStringExtra("lastNavn"));
        }

    }
}