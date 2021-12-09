package com.epiaedu.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pregunta_correcte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_correcte);

        Boolean valComplerta = getIntent().getExtras().getBoolean("complerta");
        Button seguentPregunta = findViewById(R.id.seguentPregunta);

        TextView puntsAfegits = findViewById(R.id.punts);

        if (!valComplerta) {
            puntsAfegits.setText("+100 punts");
        } else {
            puntsAfegits.setText("+0 punts \n (pregunta ja complerta)");
        }


        seguentPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }
}