package com.example.app_afslutning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SetPetName extends AppCompatActivity {

    RadioGroup rdg;
    Button btnSend;
    EditText svar;
    String type;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pet_name);
        rdg = findViewById(R.id.petTypes);
        btnSend = findViewById(R.id.sendSvar);
        svar = findViewById(R.id.svar);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedID = rdg.getCheckedRadioButtonId();
                whichType(checkedID);
                intent = getIntent();
                intent.putExtra("type", type);
                intent.putExtra("name", svar.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void whichType(int checkedID){
        switch (checkedID)
        {
            case R.id.mother:
                type = "Mother";
                break;
            case R.id.father:
                type = "Father";
                break;
            case R.id.dog:
                type = "Dog";
                break;
            case R.id.cat:
                type = "Cat";
                break;
        }
    }
}