package com.epiaedu.botigamanoli;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class adaptadorPers extends ArrayAdapter<producte> {

    private static final int REQUEST_CODE = 5;

    private Context context;


    private ArrayList<producte> productes;


    public MainActivity accedirAlMain;

    public adaptadorPers(Context context, ArrayList<producte> productes) {
        super(context, 0, productes);
        this.context = context;
        this.productes = productes;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View llistaItem = convertView;
        if (llistaItem == null)
            llistaItem = LayoutInflater.from(context).inflate(R.layout.element_llista, parent, false);

        producte producteActual = (producte) getItem(position);

        ImageView botoFav = (ImageView) llistaItem.findViewById(R.id.favorit);

        TextView descripcio = (TextView) llistaItem.findViewById(R.id.descripcio);
        descripcio.setText(producteActual.getDescripcio());

        TextView categoria = (TextView) llistaItem.findViewById(R.id.categoria);
        categoria.setText(producteActual.getCategoria());

        TextView preu = (TextView) llistaItem.findViewById(R.id.preu);

        String preuString = Double.toString(producteActual.getPreu());

        preu.setText(preuString.replace(".", ","));

        TextView fabricant = (TextView) llistaItem.findViewById(R.id.fabricant);
        fabricant.setText(producteActual.getFabricant());


        //Canvi de color segons categoria

        canviColor(producteActual, llistaItem);


        if (producteActual.getFavorit()) {
            botoFav.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            botoFav.setImageResource(android.R.drawable.btn_star_big_off);
        }


        //Al clicar el botó de favorit
        botoFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (producteActual.getFavorit()) {

                    producteActual.setFavorit(false);

                } else {

                    producteActual.setFavorit(true);

                }

                notifyDataSetChanged();

              //  accedirAlMain.actualitzarComptador(accedirAlMain.comptador);


            }
        });

        llistaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, activity_element.class);
                intent.putExtra("descripcio", producteActual.getDescripcio());
                intent.putExtra("categoria", producteActual.getCategoria());
                intent.putExtra("preu", producteActual.getPreu());
                intent.putExtra("fabricant", producteActual.getFabricant());
                intent.putExtra("comentari", producteActual.getComentari());
                intent.putExtra("posicio", position);
                ((Activity) context).startActivityForResult(intent, REQUEST_CODE);


            }
        });

        return llistaItem;
    }

    public void canviColor(producte producteActual, View llistaItem) {

        if (producteActual.getCategoria().equals("Electrònica")) {

            llistaItem.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.cat1));

        } else if (producteActual.getCategoria().equals("Perfumeria")) {

            llistaItem.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.cat2));

        } else if (producteActual.getCategoria().equals("Alimentació")) {

            llistaItem.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.cat3));
        }
    }


    public int getRequestCode() {
        return this.REQUEST_CODE;
    }

    public void filtrarLlista(ArrayList<producte> llistaFiltrada) {
        productes = llistaFiltrada;
        notifyDataSetChanged();
    }
}
