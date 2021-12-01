package com.epiaedu.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pregunta_correcte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_correcte);

        Boolean valComplerta = getIntent().getExtras().getBoolean("complerta");
        TextView puntsAfegits = findViewById(R.id.botoCorrecte);

        if (valComplerta) {
            puntsAfegits.setText("+100 punts");
        }

        else {
            puntsAfegits.setText("+0 punts");
        }

    }
}