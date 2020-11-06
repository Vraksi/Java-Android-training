package com.example.app_afslutning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PickColor extends AppCompatActivity {

    String type, preRed, preBlue, preGreen, combined;
    TextView typetxt, colorPreview;
    Spinner spnRed, spnBlue, spnGreen;
    Button btnSend;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_color);
        typetxt = findViewById(R.id.type);
        colorPreview = findViewById(R.id.colorPreview);
        btnSend = findViewById(R.id.sendColor);
        spnRed = findViewById(R.id.spnRed);
        spnBlue = findViewById(R.id.spnBlue);
        spnGreen = findViewById(R.id.spnGreen);



        String[] arr = {"00", "10", "20", "30","40", "50","60","70","80","90","A0","B0","C0","D0","E0","F0","FF"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                arr
        );

        spnRed.setAdapter(adapter);
        spnBlue.setAdapter(adapter);
        spnGreen.setAdapter(adapter);

        spnRed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                preRed = spnRed.getSelectedItem().toString();
                preBlue = spnBlue.getSelectedItem().toString();
                preGreen = spnGreen.getSelectedItem().toString();
                combined = preRed + preBlue + preGreen;
                int colorInt = Integer.parseInt(combined, 16);
                colorInt += 0xFF000000;
                colorPreview.setBackgroundColor(colorInt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnBlue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                preRed = spnRed.getSelectedItem().toString();
                preBlue = spnBlue.getSelectedItem().toString();
                preGreen = spnGreen.getSelectedItem().toString();
                combined = preRed + preBlue + preGreen;
                int colorInt = Integer.parseInt(combined, 16);
                colorInt += 0xFF000000;
                colorPreview.setBackgroundColor(colorInt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnGreen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                preRed = spnRed.getSelectedItem().toString();
                preBlue = spnBlue.getSelectedItem().toString();
                preGreen = spnGreen.getSelectedItem().toString();
                combined = preRed + preBlue + preGreen;
                int colorInt = Integer.parseInt(combined, 16);
                colorInt += 0xFF000000;
                colorPreview.setBackgroundColor(colorInt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        type = String.format("%ss color",getIntent().getStringExtra("type"));
        typetxt.setText(type);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = getIntent();
                intent.putExtra("color", combined);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}