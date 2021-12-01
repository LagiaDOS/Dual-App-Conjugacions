package com.epiaedu.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tenda extends AppCompatActivity {

    public static int punts = 0;

    private activity_pregunta activity_pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenda);


        activity_pregunta = new activity_pregunta();


        activity_pregunta.accedirtenda = tenda.this;

        TextView puntsActuals = findViewById(R.id.puntsActuals);


            puntsActuals.append(Integer.toString(punts));



    }


    public void afegirPunts() {

        punts += 100;
    }
}