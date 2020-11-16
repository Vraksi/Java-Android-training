package com.example.personclientapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.personclientapi.ServiceBuilder.buildService;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetPersons();

    }

    private void GetPersons()
    {
        ArrayList<Person> persons = new ArrayList<Person>();
        PersonService service = ServiceBuilder.buildService(PersonService.class);

        Call<List<Person>> request = service.GetPersons();

        request.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                for (Person f: response.body())
                {
                    persons.add(f);
                    System.out.println(f.getName());
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


}