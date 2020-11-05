package com.example.regnemaskine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculater extends AppCompatActivity {

    EditText tempResult;
    Button btn;
    String number1, number2, string;
    TextView placeHolder, i;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);
        placeHolder = findViewById(R.id.placeHolder);
        tempResult = findViewById(R.id.tempResult);
        btn = findViewById(R.id.goBack);
        i = findViewById(R.id.i);

        number1 = getIntent().getStringExtra("number1");
        number2 = getIntent().getStringExtra("number2");

        string = String.format("hvad er %s + %s", number1, number2);
        i.setText("peter");
        placeHolder.setText(string);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(number1) + Integer.parseInt(number2);

                if (num == Integer.parseInt(tempResult.getText().toString())){
                    intent = getIntent();
                    intent.putExtra("result", num);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    i.setText("Wrong number");
                    i.setTextColor(0xff0000);
                }
            }
        });
    }


}