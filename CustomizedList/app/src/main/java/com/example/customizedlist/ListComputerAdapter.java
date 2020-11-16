package com.example.customizedlist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListComputerAdapter extends BaseAdapter {

    private ArrayList<Computer> computerList;
    private MainActivity context;
    public ListComputerAdapter(ArrayList<Computer> computers, MainActivity mainActivity)
    {
        computerList = computers;
        context = mainActivity;

    }

    @Override
    public int getCount() {
        return computerList.size();
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
        View v = inflater.inflate(R.layout.computer, null);
        Computer computer = computerList.get(position);

        TextView txtOverskrift = v.findViewById(R.id.overskrift);
        TextView txtDetaljer = v.findViewById(R.id.detaljer);
        ImageView imgComp = v.findViewById(R.id.imgComp);
        Button btnDel = v.findViewById(R.id.btnDel);

        txtOverskrift.setText(computer.getOverSkrift());
        txtDetaljer.setText(computer.getBesskrivelse());
        imgComp.setImageResource(computer.getBilledNr());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Delete Computer");
                alert.setMessage("Er du sikker ?");
                alert.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        computerList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("Nej", null);
                alert.show();
            }
        });

        return v;
    }
}
