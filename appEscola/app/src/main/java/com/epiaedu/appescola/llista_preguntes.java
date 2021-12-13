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

    private int RESULT_INCORRECT = 5;

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    int result = activityResult.getResultCode();
                    Intent data = activityResult.getData();

                    int posicio = data.getIntExtra("posicio", 0);

                    if (result == RESULT_OK) {


                        if (((pregunta) arrayPreguntes.get(posicio)).getComplerta()) {
                            Intent myIntent = new Intent(llista_preguntes.this, pregunta_correcte.class);
                            myIntent.putExtra("complerta", true);
                            startActivity(myIntent);
                        } else {
                            ((pregunta) arrayPreguntes.get(posicio)).setComplerta(true);
                            adaptador.notifyDataSetChanged();
                            desar();

                            Intent myIntent = new Intent(llista_preguntes.this, pregunta_correcte.class);
                            myIntent.putExtra("complerta", false);
                            startActivity(myIntent);
                        }


                    } else if (result == RESULT_INCORRECT) {
                        Intent myIntent = new Intent(llista_preguntes.this, pregunta_incorrecte.class);
                        startActivity(myIntent);
                    }


                    //Retorna a l'usuari a l'última pregunta que va clicar, per tant de no estar tota l'estona lliscant cap amunt
                    llista.smoothScrollToPosition(posicio);
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

        arrayPreguntes.add(new pregunta("Pregunta 2",
                "Digues el present d'indicatiu de \"sopar\"",
                "jo sopava",
                "jo sopo",
                "jo havia sopat",
                "jo sopi",
                "jo sopo"));

        arrayPreguntes.add(new pregunta("Pregunta 3",
                "Digues el imperfet d'indicatiu de \"agafar\"",
                "jo agafava",
                "jo hauré agafat",
                "jo agafaré",
                "jo hauria agafat",
                "jo agafava"));

        arrayPreguntes.add(new pregunta("Pregunta 4",
                "De quina forma acaben els verbs de la segona conjugació?",
                "-er/re",
                "-re",
                "-ir",
                "-at",
                "-er/re"));


        arrayPreguntes.add(new pregunta("Pregunta 5",
                "Digues el condicional de \"guanyar\"",
                "jo guanyi",
                "jo hagués guanyat",
                "jo guanyés",
                "jo guanyaria",
                "jo guanyaria"));


        arrayPreguntes.add("Mitjà");


        arrayPreguntes.add(new pregunta("Pregunta 6",
                "Digues el subjuntiu imperfet de \"lluitar\"",
                "jo lluiti",
                "jo lluités",
                "jo hagi lluitat",
                "jo hagués lluitat",
                "jo lluités"));


        arrayPreguntes.add(new pregunta("Pregunta 7",
                "Quin és el indicatiu imperfet de la segona persona del singular del verb \"aixafar\"?",
                "aixafe",
                "aixafo",
                "aixafa",
                "aixafes",
                "aixafo"));


        arrayPreguntes.add(new pregunta("Pregunta 8",
                "Com s'escriu el gerundi de \"ajeure\"?",
                "ajaient",
                "ajagut",
                "ajaguet",
                "ajagues",
                "ajaient"));

        arrayPreguntes.add(new pregunta("Pregunta 9",
                "Quin és el indicatiu imperfet de la segona persona del singular del verb \"trencar\"?",
                "trencadiu",
                "trencavas",
                "trencaves",
                "trencaven",
                "trencaves"));


        arrayPreguntes.add(new pregunta("Pregunta 10",
                "Quin és el futur indicatiu de la tercera persona del singular del verb \"introduir\"?",
                "introduiré",
                "introduirem",
                "introdueixes",
                "introduirà",
                "introduirà"));


        arrayPreguntes.add("Difícil");

        arrayPreguntes.add(new pregunta("Pregunta 11",
                "Què és un verb irregular?",
                "Un verb que no s'accentua mai",
                "Un verb que té conjugacions uniformes",
                "Un verb amb només 3 síl·labes",
                "Un verb que no té participi",
                "Un verb que té conjugacions uniformes"));


        arrayPreguntes.add(new pregunta("Pregunta 12",
                "Digues el temps verbal d'aquest verb indicatiu: ell hauria descansat",
                "Imperfet",
                "Passat simple",
                "Futur",
                "Condicional perfet",
                "Condicional perfet"));


        arrayPreguntes.add(new pregunta("Pregunta 13",
                "Quin és el passat indicatiu de la segona persona del plural del verb \"oir\"?",
                "oireu",
                "oida",
                "oi",
                "oiren",
                "oireu"));


        arrayPreguntes.add(new pregunta("Pregunta 14",
                "Quin és el passat indicatiu de la primera persona del plurar del verb \"espiar\"?",
                "espiarem",
                "espia",
                "espiariem",
                "espiaren",
                "espiarem"));


        arrayPreguntes.add(new pregunta("Pregunta 15",
                "Quin és el futur indicatiu de la primera persona del singular del verb \"espatllar\"?",
                "espatgina",
                "espatllaré",
                "espatllaran",
                "espatlla",
                "espatllaré"));


        arrayPreguntes.add(new pregunta("Pregunta 16",
                "Quin és el present condicional de la primera persona del plural del verb \"viure\"?",
                "viurien",
                "viuria",
                "viuriues",
                "viuriem",
                "viuriem"));


        arrayPreguntes.add(new pregunta("Pregunta 17",
                "Quin és el gerundi del verb \"pertànyer\"?",
                "pertanyut",
                "pertanyent",
                "pertanguides",
                "pertangut",
                "pertanyent"));


        arrayPreguntes.add(new pregunta("Pregunta 18",
                "Quin és el infinitu de \"cabut\"?",
                "cabent",
                "cabida",
                "cabre",
                "cabet",
                "cabre"));

        arrayPreguntes.add(new pregunta("Pregunta 19",
                "Quin és el present subjuntiu de la tercera persona del plural del verb \"estar\"?",
                "estigui",
                "estiguin",
                "estiguem",
                "estiguen",
                "estiguin"));


        arrayPreguntes.add(new pregunta("Pregunta 20",
                "Quin és el present subjuntiu de la segona persona del singular del verb \"agregar\"?",
                "agreguis",
                "agreguem",
                "agregueu",
                "agreguin",
                "agreguis"));


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
                if (json.toString().matches(".*\\b(Fàcil|Mitjà|Difícil)\\b.*")) {
                    arrayTemporal.add(gson.fromJson(json, String.class));
                } else {
                    arrayTemporal.add(gson.fromJson(json, pregunta.class));
                }
            }

            arrayPreguntes = arrayTemporal;
        }


    }
}