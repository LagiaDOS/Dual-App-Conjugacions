package com.epiaedu.botigamanoli;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private adaptadorPers adaptador;

    public static ArrayList<producte> productes = new ArrayList<>();
    public static TextView comptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView filtrarTots = findViewById(R.id.filtrarTots);
        ImageView filtrarFav = findViewById(R.id.filtrarFav);
        ImageView filtrarDesc = findViewById(R.id.filtrarDesc);
        ImageView filtrarPreu = findViewById(R.id.filtrarPreu);
        ImageView infoEmpresa = findViewById(R.id.infoEmpresa);
        comptador = findViewById(R.id.comptador);

        listView = findViewById(R.id.llista);

        //Evitar que la llista es dupliqui cada vegada que es gira la pantalla

        if (savedInstanceState == null) {
            afegirInfo(productes);
        }


        adaptador = new adaptadorPers(this, productes);
        listView.setAdapter(adaptador);

        adaptador.accedirAlMain = MainActivity.this;


        filtrarTots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrarTots(productes);

            }
        });

        filtrarFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrarFav(productes);
            }
        });

        filtrarPreu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrarPreu(productes);
            }
        });

        filtrarDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrarDesc(productes);
            }
        });


        infoEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), activity_empresa.class);
                startActivity(intent);
            }
        });


    }


    public void afegirInfo(ArrayList<producte> productes) {

        productes.add(new producte("iPhone 2", "Electrònica", 5.99, "Apple", ""));
        productes.add(new producte("Perfum Paco Rabanne", "Perfumeria", 9.99, "Paco Rabanne", ""));
        productes.add(new producte("Galetes Maria", "Alimentació", 12.00, "Nestlé", ""));
        productes.add(new producte("Portàtil HP GTX-2434", "Electrònica", 725.00, "Hewlett-Packard", ""));
        productes.add(new producte("Patates Lays Edició Limitada", "Alimentació", 1000.00, "Lays", ""));
        productes.add(new producte("La Vie Est Belle", "Perfumeria", 28.50, "Lancome", ""));
        productes.add(new producte("PC Sobretaula Mars Gaming", "Electrònica", 999.99, "Mars Gaming", ""));
        productes.add(new producte("PlayStation 5", "Electrònica", 700.00, "Sony", ""));
        productes.add(new producte("Terre d'Hermès", "Perfumeria", 49.99, "Hermès", ""));
        productes.add(new producte("Oli d'oliva Coosur", "Alimentació", 3.50, "Coosur", ""));
        productes.add(new producte("Càmera GoPro Hero 5", "Electrònica", 450.00, "GoPro", ""));
        productes.add(new producte("Giorgio Armani", "Perfumeria", 79.99, "Giorgio Armani S.P.A", ""));
        productes.add(new producte("Smints sabor llimona", "Alimentació", 4.85, "SMINT", ""));
        productes.add(new producte("Smart TV LED 163,9 cm", "Electrònica", 600.00, "LG", ""));
        productes.add(new producte("Loewe Solo Ella", "Perfumeria", 50.40, "Loewe", ""));
        productes.add(new producte("Ous frescs de gallines camperes", "Alimentació", 1.69, "El Corte Inglés", ""));
        productes.add(new producte("Patinet elèctric Xiaomi Mi Scooter", "Electrònica", 349.99, "Xiaomi", ""));
        productes.add(new producte("Yves Saint Laurent Eau de Parfum", "Perfumeria", 89.99, "Yves Saint Laurent", ""));
        productes.add(new producte("Tomàquet fregit 560g", "Alimentació", 0.99, "El Corte Inglés", ""));
        productes.add(new producte("HP Deskjet Plus 4130E", "Electrònica", 64.90, "Hewlett-Packard", ""));

    }

    public void filtrarTots(ArrayList<producte> productes) {
        adaptador.filtrarLlista(productes);
    }

    public void filtrarFav(ArrayList<producte> productes) {

        ArrayList<producte> productesFiltrats = new ArrayList<>();

        for (int i = 0; i < productes.size(); i++) {

            if (productes.get(i).getFavorit()) {
                productesFiltrats.add(productes.get(i));
            }

        }

        if (productesFiltrats.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.noFavorits, Toast.LENGTH_SHORT).show();
        } else {

            adaptadorPers adaptadorPreu = new adaptadorPers(this, productesFiltrats);
            listView.setAdapter(adaptadorPreu);
            adaptadorPreu.notifyDataSetChanged();
        }


    }

    public void filtrarPreu(ArrayList<producte> productes) {

        ArrayList<producte> productesFiltrats = new ArrayList<>();

        for (int i = 0; i < productes.size(); i++) {

            productesFiltrats.add(productes.get(i));

        }

        Collections.sort(productesFiltrats, Comparator.comparing(producte::getPreu));

        Collections.reverse(productesFiltrats);
        adaptadorPers    adaptadorPreu = new adaptadorPers(this, productesFiltrats);
        listView.setAdapter(adaptadorPreu);
        adaptadorPreu.notifyDataSetChanged();
       // adaptador.filtrarLlista(productesFiltrats);

    }


    public void filtrarDesc(ArrayList<producte> productes) {

        ArrayList<producte> productesFiltrats = new ArrayList<>();

        for (int i = 0; i < productes.size(); i++) {

            productesFiltrats.add(productes.get(i));

        }

        Collections.sort(productesFiltrats, Comparator.comparing(producte::getDescripcio));


        adaptador.filtrarLlista(productesFiltrats);


    }


    public void actualitzarComptador(ArrayList<producte> productes, TextView comptador) {

        int cont = 0;

        for (int i = 0; i < productes.size(); i++) {

            if (productes.get(i).getFavorit()) {
                cont++;

            }
        }


        comptador.setText(Integer.toString(cont));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == adaptador.getRequestCode()) {

            if (resultCode == Activity.RESULT_OK) {

                String descripcio = data.getStringExtra("descripcio");
                String comentari = data.getStringExtra("comentari");

                for (int i = 0; i < productes.size(); i++) {
                    if (productes.get(i).getDescripcio().equals(descripcio)) {
                        productes.get(i).setComentari(comentari);
                    }
                }

                adaptador.notifyDataSetChanged();

            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outInstanceState) {
        super.onSaveInstanceState(outInstanceState);
        outInstanceState.putInt("value", 1);
    }
}
