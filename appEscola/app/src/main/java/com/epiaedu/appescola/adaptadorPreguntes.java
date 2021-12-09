package com.epiaedu.appescola;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adaptadorPreguntes extends ArrayAdapter<Object> {
    private Context context;
    private ArrayList<Object> arrayPreguntes;


    static final int ESPREGUNTA = 1;
    static final int ESCATEGORIA = 0;

    public adaptadorPreguntes(Context context, ArrayList<Object> arrayPreguntes) {
        super(context, 0, arrayPreguntes);
        this.context = context;
        this.arrayPreguntes = arrayPreguntes;
    }

    @Override
    public int getCount() {
        return arrayPreguntes.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayPreguntes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getTipusItem(int position) {
        if (getItem(position) instanceof pregunta) {
            return ESPREGUNTA;
        } else
            return ESCATEGORIA;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View llistaItem = convertView;

        int tipus = getTipusItem(position);

        Object elementActual = getItem(position);

       // if (llistaItem == null) {

         //   LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            switch (tipus) {
                case ESPREGUNTA:
                    llistaItem =  LayoutInflater.from(getContext()).inflate(R.layout.element_llista, parent, false);
                    break;

                case ESCATEGORIA:
                    llistaItem = LayoutInflater.from(getContext()).inflate(R.layout.element_categoria, parent, false);
                    break;
            }
     //   }

        if (elementActual != null) {
            switch (tipus) {

                case ESPREGUNTA:

                    pregunta preguntaActual = (pregunta) getItem(position);

                    TextView titolPregunta = llistaItem.findViewById(R.id.titolPregunta);
                    ImageView imatge = llistaItem.findViewById(R.id.imgComplert);

                    titolPregunta.setText(preguntaActual.getNumero());

                    //En cas que la pregunta s'hagi superat es mostrarà el tick
                    if (preguntaActual.getComplerta()) {
                        imatge.setVisibility(View.VISIBLE);
                    } else {
                        imatge.setVisibility(View.INVISIBLE);
                    }

                    break;


                case ESCATEGORIA:

                    String categoriaActual = (String) getItem(position);

                    TextView titolCategoria = llistaItem.findViewById(R.id.titolCategoria);


                   titolCategoria.setText(categoriaActual);

                    break;

            }
        }


        return llistaItem;
    }


}