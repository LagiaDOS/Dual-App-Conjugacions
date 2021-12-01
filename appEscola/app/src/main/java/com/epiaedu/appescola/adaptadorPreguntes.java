package com.epiaedu.appescola;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adaptadorPreguntes extends BaseAdapter {
    private Context context;
    private ArrayList<Object> arrayPreguntes;

    LayoutInflater inflater;

    static final int ESPREGUNTA = 1;
    static final int ESCATEGORIA = 0;

    public adaptadorPreguntes(Context context, ArrayList<Object> arrayPreguntes) {
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
        } else {
            return ESCATEGORIA;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int tipus = getTipusItem(position);


        if (convertView == null) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //  convertView = LayoutInflater.from(context).inflate(R.layout.element_llista, parent, false);

            switch (tipus) {
                case ESPREGUNTA:
                    convertView = inflater.inflate(R.layout.element_llista, null);
                    break;

                case ESCATEGORIA:
                    convertView = inflater.inflate(R.layout.element_categoria, null);
                    break;
            }

        }

        switch (tipus) {


            case ESPREGUNTA:

                pregunta preguntaActual = (pregunta) getItem(position);

                TextView titolPregunta = convertView.findViewById(R.id.titolCategoria);
                ImageView imatge = convertView.findViewById(R.id.imgComplert);

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
                TextView titolCategoria = convertView.findViewById(R.id.titolCategoria);

                titolCategoria.setText(categoriaActual);
                break;

        }

      /*  convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getTipusItem(position) == ESPREGUNTA) {

                    pregunta preguntaActual = (pregunta) getItem(position);

                    Intent intent = new Intent(context, activity_pregunta.class);

                    intent.putExtra("posicio", position);
                    intent.putExtra("numero", preguntaActual.getNumero());
                    intent.putExtra("enunciat", preguntaActual.getEnunciat());
                    intent.putExtra("opcio1", preguntaActual.getOpcio1());
                    intent.putExtra("opcio2", preguntaActual.getOpcio2());
                    intent.putExtra("opcio3", preguntaActual.getOpcio3());
                    intent.putExtra("opcio4", preguntaActual.getOpcio4());
                    intent.putExtra("resposta", preguntaActual.getResposta());
                    intent.putExtra("complerta", preguntaActual.getComplerta());


                    context.startActivity(intent);
                }
                else {
                    Toast toast1 =
                            Toast.makeText(context,
                                    "Toast por defecto", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });
*/
        return convertView;
    }


}