package com.example.personclientapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPerson extends AppCompatActivity {
    EditText name, job, birthYear, relationshipStatus;
    TextView header;
    Spinner gender;
    RadioGroup driversLicense;
    Button sendAnswer;
    Intent intent;
    //Person p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        PersonService service = ServiceBuilder.buildService(PersonService.class);
        header = findViewById(R.id.header);
        name = findViewById(R.id.name);
        job = findViewById(R.id.job);
        birthYear = findViewById(R.id.yearOfBirth);
        driversLicense = findViewById(R.id.driversLicense);
        gender = findViewById(R.id.gender);
        relationshipStatus = findViewById(R.id.relationshipStatus);
        sendAnswer = findViewById(R.id.sendAnswer);

        String[] arr = {"Male", "Female", "Non-Binary", "Pan-gender"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                arr
        );
        gender.setAdapter(adapter);
        intent = getIntent();

        if (intent.getBooleanExtra("bool", false) == true)
        {
            header.setText("Update Person");
            sendAnswer.setText("Update Person");
            Gson gson = new Gson();
            Person per = gson.fromJson(intent.getStringExtra("person"), Person.class);
            name.setText(per.getName());
            job.setText(per.getJob());
            birthYear.setText(Integer.toString(per.getYearOfBirth()));
            relationshipStatus.setText(per.getRelationshipStatus());

            sendAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person p = new Person();
                    int checkedID = driversLicense.getCheckedRadioButtonId();
                    p.setId(per.getId());
                    p.setName(name.getText().toString());
                    p.setJob(job.getText().toString());
                    p.setYearOfBirth(Integer.parseInt(birthYear.getText().toString()));
                    p.setGender(gender.getSelectedItem().toString());
                    p.setDriversLicense(DriversLicenseTrueOrFalse(checkedID));
                    p.setRelationshipStatus(relationshipStatus.getText().toString());

                    Call<Void> request = service.updatePerson(p);
                    request.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            System.out.println("Posted Person");

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            System.out.println("Didnt Post Person");
                        }
                    });
                    finish();
                }
            });
        }
        else{
            sendAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person p = new Person();
                    int checkedID = driversLicense.getCheckedRadioButtonId();
                    p.setName(name.getText().toString());
                    p.setJob(job.getText().toString());
                    p.setYearOfBirth(Integer.parseInt(birthYear.getText().toString()));
                    p.setGender(gender.getSelectedItem().toString());
                    p.setDriversLicense(DriversLicenseTrueOrFalse(checkedID));
                    p.setRelationshipStatus(relationshipStatus.getText().toString());

                    Call<Void> request = service.addPerson(p);
                    request.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            System.out.println("Posted Person");
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            System.out.println("Didnt Post Person");
                        }
                    });
                    finish();
                }
            });
        }
        }



    private Boolean DriversLicenseTrueOrFalse(int checkedID)
    {
        Boolean B = false;
        switch (checkedID)
        {
            case R.id.driversLicenseTrue:
                B = true;
                break;
            case R.id.driversLicenseFalse:
                B = false;
                break;
        }
        return B;
    }
}







