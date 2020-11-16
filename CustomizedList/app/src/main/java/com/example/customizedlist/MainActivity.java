package com.example.customizedlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer("dwkwadawd", "dwaddawdawdwadaw", R.drawable.pc01));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc02));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc03));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc04));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc05));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc07));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc08));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc09));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc10));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc11));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc12));
        computers.add(new Computer("dwk", "dwad", R.drawable.pc14));

        ListComputerAdapter listComputerAdapter = new ListComputerAdapter(computers, this);

        ListView listView = findViewById(R.id.lstComputers);
        listView.setAdapter(listComputerAdapter);
    }
}

