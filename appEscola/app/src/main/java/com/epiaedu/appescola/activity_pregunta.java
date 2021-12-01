package com.epiaedu.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_pregunta extends AppCompatActivity {

    public ArrayList<pregunta> arrayPreguntes;
    public TextView pregunta;
    public TextView enunciat;

    public Button opcio1;
    public Button opcio2;
    public Button opcio3;
    public Button opcio4;

    public tenda accedirtenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        pregunta = findViewById(R.id.titolSeccio);
        enunciat = findViewById(R.id.enunciat);


        opcio1 = findViewById(R.id.opcio1);
        opcio2 = findViewById(R.id.opcio2);
        opcio3 = findViewById(R.id.opcio3);
        opcio4 = findViewById(R.id.opcio4);

        arrayPreguntes = new ArrayList<>();

        Integer valPosicio = getIntent().getExtras().getInt("posicio");
        String valPregunta = getIntent().getExtras().getString("numero");
        String valEnunciat = getIntent().getExtras().getString("enunciat");
        String valOpcio1 = getIntent().getExtras().getString("opcio1");
        String valOpcio2 = getIntent().getExtras().getString("opcio2");
        String valOpcio3 = getIntent().getExtras().getString("opcio3");
        String valOpcio4 = getIntent().getExtras().getString("opcio4");
        String valResposta = getIntent().getExtras().getString("resposta");
        Boolean valComplerta = getIntent().getExtras().getBoolean("complerta");

        setDades(valPregunta, valEnunciat, valOpcio1, valOpcio2, valOpcio3, valOpcio4);

        //Clic botó 1
        opcio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcio1.getText().toString().equals(valResposta)) {

                    Intent intent = new Intent();
                    intent.putExtra("posicio", valPosicio);
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
                    //Obrir intent incorrecte

                }
            }
        });

        opcio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcio2.getText().toString().equals(valResposta)) {

                    Intent intent = new Intent();
                    intent.putExtra("posicio", valPosicio);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    //Obrir intent incorrecte

                }
            }
        });

        opcio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcio3.getText().toString().equals(valResposta)) {

                    Intent intent = new Intent();
                    intent.putExtra("posicio", valPosicio);
                    setResult(RESULT_OK, intent);

                    Intent myIntent = new Intent(activity_pregunta.this, pregunta_correcte.class);
                    myIntent.putExtra("complerta", valComplerta);
                    startActivity(myIntent);

                    //S'afegiran els punts només en cas de que la pregunta encara no hagi sigut superada
                    if (valComplerta == false) {
                        accedirtenda.punts += 100;
                    }



                    //  finish();
                } else {

                  //  Intent myIntent = new Intent(activity_pregunta.this, pregunta_incorrecte.class);
                   // startActivity(myIntent);

                }
            }
        });

        opcio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcio4.getText().toString().equals(valResposta)) {

                    Intent intent = new Intent();
                    intent.putExtra("posicio", valPosicio);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    //Obrir intent incorrecte

                }
            }
        });

    }


    public void setDades(String valPregunta, String valEnunciat, String valOpcio1, String valOpcio2, String valOpcio3, String valOpcio4) {
        //Agafa les dades que s'han passat per l'intent i les aplica

        pregunta.setText(valPregunta);
        enunciat.setText(valEnunciat);
        opcio1.setText(valOpcio1);
        opcio2.setText(valOpcio2);
        opcio3.setText(valOpcio3);
        opcio4.setText(valOpcio4);

    }
}