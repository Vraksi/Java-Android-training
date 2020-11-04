package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText FrstNum;
    EditText ScndNum;
    EditText Result;
    Button BtnPlus;
    Button BtnMinus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








        /*
        FrstNum = findViewById(R.id.FrstNum);
        ScndNum = findViewById(R.id.ScndNum);
        Result = (EditText)findViewById(R.id.Result);
        BtnPlus = findViewById(R.id.Plus);
        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(FrstNum.getText().toString()) + Integer.parseInt(ScndNum.getText().toString());
                String s = String.valueOf(i);
                Result.setText(s);
            }
        });
        BtnMinus = findViewById(R.id.Minus);
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(FrstNum.getText().toString()) - Integer.parseInt(ScndNum.getText().toString());
                String s = String.valueOf(i);
                Result.setText(s);
            }
        });
*/
    }

    @Override
    public void onClick(View v) {

    }

}