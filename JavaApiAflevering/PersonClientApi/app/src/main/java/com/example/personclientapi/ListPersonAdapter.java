package com.example.personclientapi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPersonAdapter extends BaseAdapter {

    private ArrayList<Person> personList;
    private MainActivity context;
    private final int REQ_DEL = 1;
    Intent intent;

    public ListPersonAdapter(ArrayList<Person> persons, MainActivity mainActivity)
    {
        personList = persons;
        context = mainActivity;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.persons_list, null);
        Person person = personList.get(position);

        TextView name = v.findViewById(R.id.name);
        TextView job = v.findViewById(R.id.job);
        Button btnDel = v.findViewById(R.id.btnDel);

        name.setText(person.getName());
        job.setText(person.getJob());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Slet person");
                alert.setMessage("Er du sikker på at du vil slette");
                alert.setPositiveButton("ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deletePerson(person.getId());
                        personList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("Nej", null);
                alert.show();
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, PersonView.class);
                Gson gson = new Gson();
                String Json = gson.toJson(person);
                intent.putExtra("person", Json);
                context.startActivityForResult(intent, REQ_DEL);
            }
        });

        return v;
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

