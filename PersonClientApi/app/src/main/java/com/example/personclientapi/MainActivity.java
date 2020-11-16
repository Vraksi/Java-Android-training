package com.example.personclientapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.personclientapi.ServiceBuilder.buildService;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton FAB;
    Intent intent;
    final int REQ_POST_PERSON = 1;
    final int REQ_DEL = 0;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetPersons();

        FAB = findViewById(R.id.btnAdd);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, AddPerson.class);
                startActivityForResult(intent, REQ_POST_PERSON);
            }
        });
    }

    private void GetPersons()
    {
        persons = new ArrayList<Person>();
        PersonService service = ServiceBuilder.buildService(PersonService.class);

        Call<List<Person>> request = service.GetPersons();

        request.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                for (Person f: response.body())
                {
                    persons.add(f);
                }
                ListPersonAdapter listPersonAdapter = new ListPersonAdapter(persons, MainActivity.this);
                ListView listView = findViewById(R.id.lstPersons);
                listView.setAdapter(listPersonAdapter);
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                System.out.println("den fejlede");
            }
        });


    }

    private void GetPersonById(int id)
    {
        PersonService service = ServiceBuilder.buildService(PersonService.class);
        Call<Person> request = service.GetPersonById(id);

        request.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Person p = response.body();
                System.out.println(p.name);
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_DEL)
        {
            persons.remove(data.getIntExtra("toDel", -1));
            //GetPersons();
        }
        GetPersons();
    }
}