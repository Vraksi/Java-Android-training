package com.example.personclientapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonView extends AppCompatActivity {
    TextView name, job, birthYear, driversLicense, gender, relationshipStatus;
    Button btnUpdate, btnDelete;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_view);

        name = findViewById(R.id.name);
        job = findViewById(R.id.job);
        birthYear = findViewById(R.id.yearOfBirth);
        driversLicense = findViewById(R.id.driversLicense);
        gender = findViewById(R.id.gender);
        relationshipStatus = findViewById(R.id.relationshipStatus);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        String json = getIntent().getStringExtra("person");

        Gson g = new Gson();
        Person p = g.fromJson(json, Person.class);
        //System.out.println(p.getName());

        name.setText(p.getName());
        job.setText(p.getJob());
        birthYear.setText(Integer.toString(p.getYearOfBirth()));
        if (p.getDriversLicense())
        {
            driversLicense.setText("You have a driversLicense");
        }
        else
        {
            driversLicense.setText("You dont have a driversLicense");
        }
        gender.setText(p.getGender());
        relationshipStatus.setText(p.getRelationshipStatus());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(PersonView.this);
                alert.setTitle("Slet person");
                alert.setMessage("Er du sikker på at du vil slette");
                alert.setPositiveButton("ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deletePerson(p.getId());
                        intent = getIntent();
                        intent.putExtra("toDel", p.getId());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
                alert.setNegativeButton("Nej", null);
                alert.show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonView.this, AddPerson.class);
                Gson g = new Gson();
                String json = g.toJson(p);
                Boolean b = true;
                intent.putExtra("bool", b);
                intent.putExtra("person", json);
                startActivity(intent);
            }
        });
    }


    private void deletePerson(int id)
    {
        PersonService service = ServiceBuilder.buildService(PersonService.class);
        Call<Void> request = service.deletePersonById(id);
        request.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("Person deleted");

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("Person NOT deleted");
            }
        });
    }
}