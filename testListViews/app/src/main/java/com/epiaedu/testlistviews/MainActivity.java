package com.epiaedu.testlistviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         ListView listview;
        ArrayList<videojoc> videojocs;

        videojocs = new ArrayList<videojoc>();


        listview = (ListView) findViewById(R.id.listview);

        videojocs.add(new videojoc("Assassin's Creed Valhalla", "tu puta madre", "Ubisoft Montreal"));
        videojocs.add(new videojoc("Assassin's Creed Tu puta madre", "lol", "Ubisoft Albacete"));

        ArrayAdapter adaptadorPers = new ArrayAdapter(this, 0, videojocs);
        listview.setAdapter(adaptadorPers);
    }

}