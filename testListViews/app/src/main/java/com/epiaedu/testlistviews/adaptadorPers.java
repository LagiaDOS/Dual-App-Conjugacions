package com.epiaedu.testlistviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptadorPers extends ArrayAdapter<videojoc> {

    private ArrayList<videojoc> videojocs;
    private Context context;

    public adaptadorPers(Context context, ArrayList<videojoc> videojocs) {
        super(context, 0, videojocs);

        this.videojocs = videojocs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return videojocs.size();
    }

    @Override
    public videojoc getItem(int position) {
        return videojocs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listajocs, parent, false);
        }
        videojoc currentMovie = videojocs.get(position);



        TextView name = (TextView) convertView.findViewById(R.id.titol);
        name.setText(currentMovie.getNom());

        TextView release = (TextView) convertView.findViewById(R.id.desenvolupador);
        release.setText(currentMovie.getDesenvolupador());

        return convertView;
    }
}

