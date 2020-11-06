package com.example.regnemaskine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView result;
    Button btn;
    Intent intent;
    final int REQ_CALCULATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btnSend);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Calculater.class);
                intent.putExtra("number1", number1.getText().toString());
                intent.putExtra("number2", number2.getText().toString());
                startActivityForResult(intent, REQ_CALCULATE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CALCULATE){
            int i = data.getIntExtra("result", 1);
            result.setText(Integer.toString(i));
        }
        
    }
}