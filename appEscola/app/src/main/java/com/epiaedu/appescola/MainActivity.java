package com.epiaedu.appescola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

/*Coses a fer:


Fer que les recompenses funcionin per API 28 o inferior
Afegir mes imatges a les activities
Canviar l'interficie per que sigui 100% responsive
Optimizar codi (afegir mes coses a metodes, canviar noms de variables)

  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button comencar = findViewById(R.id.comencar);
        TextView subtext = findViewById(R.id.benvingudaSubtext);
        ImageView tenda = findViewById(R.id.tenda);


        esPrimeraVegada(comencar, subtext);


        comencar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, llista_preguntes.class));
            }
        });



        tenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, tenda.class));

            }
        });




    }

    public void esPrimeraVegada(Button comencar, TextView subtext) {
        //Si no és la primera vegada que l'usuari executa l'aplicació, el text del botó canvia el "Començar" per "Continuar"
        SharedPreferences primeraVegada = getSharedPreferences("primeravegada", 0);

        if (primeraVegada.getBoolean("primeravegada", true)) {

            primeraVegada.edit().putBoolean("primeravegada", false).commit();
        }

        else {
            comencar.setText(R.string.continuar);
            subtext.setText(R.string.continuarSubtext);
        }
    }

}


