package com.epiaedu.appescola;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class llista_preguntes extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    int result = activityResult.getResultCode();
                    Intent data = activityResult.getData();

                    if (result == RESULT_OK) {

                        int posicio = data.getIntExtra("posicio", 0);

                        ((pregunta) arrayPreguntes.get(posicio)).setComplerta(true);
                        adaptador.notifyDataSetChanged();
                        desar();

                    }

                }
            }

    );

    private ListView llista;
    private adaptadorPreguntes adaptador;

    public ArrayList<Object> arrayPreguntes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista_preguntes);

        llista = findViewById(R.id.llistaPreguntes);
        carregar();

        adaptador = new adaptadorPreguntes(this, arrayPreguntes);
        llista.setAdapter(adaptador);

        //Quan es clica un element de la llista
        llista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicio, long id) {
                if (llista.getItemAtPosition(posicio) instanceof pregunta) {


                    String numPregunta = ((pregunta) llista.getItemAtPosition(posicio)).getNumero();

                    pregunta preguntaActual = (pregunta) llista.getItemAtPosition(posicio);

                    Intent intent = new Intent(llista_preguntes.this, activity_pregunta.class);

                    intent.putExtra("posicio", posicio);
                    intent.putExtra("numero", preguntaActual.getNumero());
                    intent.putExtra("enunciat", preguntaActual.getEnunciat());
                    intent.putExtra("opcio1", preguntaActual.getOpcio1());
                    intent.putExtra("opcio2", preguntaActual.getOpcio2());
                    intent.putExtra("opcio3", preguntaActual.getOpcio3());
                    intent.putExtra("opcio4", preguntaActual.getOpcio4());
                    intent.putExtra("resposta", preguntaActual.getResposta());
                    intent.putExtra("complerta", preguntaActual.getComplerta());


                    activityResultLauncher.launch(intent);


                }


            }
        });


    }


    public void afegirInfo() {

        arrayPreguntes.add("Fàcil");
        arrayPreguntes.add(new pregunta("Pregunta 1",
                "De quina forma acaben els verbs de la primera conjugació?",
                "-er",
                "-re",
                "-ar",
                "-ir",
                "-ar"));


    }

    public void desar() {

        SharedPreferences prefs = getSharedPreferences("AppName", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayPreguntes);
        editor.putString("key", json);
        editor.commit();
    }

    public void carregar() {


        SharedPreferences courseData = getSharedPreferences("AppName", MODE_PRIVATE);
        Gson gson = new Gson();
        String dades = courseData.getString("key", null);


        if (dades == null) {
            arrayPreguntes = new ArrayList<>();
            afegirInfo();
        } else {

            JsonArray arrayJSON = new JsonParser().parse(dades).getAsJsonArray();
            ArrayList arrayTemporal = new ArrayList();

            for (JsonElement json : arrayJSON) {
                if (json.toString().contains("Fàcil")) {
                    arrayTemporal.add(gson.fromJson(json, String.class));
                } else {
                    arrayTemporal.add(gson.fromJson(json, pregunta.class));
                }
            }

            arrayPreguntes = arrayTemporal;
        }


    }
}