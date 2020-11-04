package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

public class RadioButton extends AppCompatActivity {
    RadioGroup grp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        grp = (RadioGroup)findViewById(R.id.radioGroup);

    }
}