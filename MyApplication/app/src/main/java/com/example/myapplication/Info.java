package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Info extends AppCompatActivity {

    EditText edName, edLastName;
    Button btnSend;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        edName = findViewById(R.id.edName);
        edLastName = findViewById(R.id.edLastName);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edName.getText().toString();
                String lastName = edLastName.getText().toString();
                intent = getIntent();
                intent.putExtra("navn", name);
                intent.putExtra("lastNavn", lastName);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}