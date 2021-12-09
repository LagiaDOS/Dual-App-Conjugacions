package com.epiaedu.appescola;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class tenda extends AppCompatActivity {

    public static int punts;
    private static int REQUEST_CODE = 100;
    public static Context context;
    private activity_pregunta activity_pregunta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenda);

        context = this;



        Button reclamarOr = findViewById(R.id.reclamarOr);
        Button reclamarPlata = findViewById(R.id.reclamarPlata);
        Button reclamarBronze = findViewById(R.id.reclamarBronze);
        TextView puntsActuals = findViewById(R.id.puntsActuals);

        activity_pregunta = new activity_pregunta();
        activity_pregunta.tenda = tenda.this;



        carregarPunts();
        puntsActuals.append(Integer.toString(punts));


        reclamarOr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (punts >= 2000) {

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.medalla_or);
                    desarFotos(bitmap, "medalla_or");

                } else {
                    Toast.makeText(getApplicationContext(), R.string.sensePunts, Toast.LENGTH_LONG).show();
                }
            }
        });

        reclamarPlata.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (punts >= 1000) {

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.medalla_plata);
                    desarFotos(bitmap, "medalla_plata");

                } else {
                    Toast.makeText(getApplicationContext(), R.string.sensePunts, Toast.LENGTH_LONG).show();
                }
            }
        });

        reclamarBronze.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (punts >= 850) {

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.medalla_bronze);
                    desarFotos(bitmap, "medalla_bronze");

                } else {
                    Toast.makeText(getApplicationContext(), R.string.sensePunts, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //Aquest codi només funciona en la API 29 o superior
    public void desarFotos(Bitmap bitmap, String tipusMedalla) {
        OutputStream fos;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                ContentResolver resolver = getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, tipusMedalla + ".jpg");
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator + "recompenses");
                Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

                fos = resolver.openOutputStream(Objects.requireNonNull(imageUri));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                Objects.requireNonNull(fos);

                //00B733
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), R.string.recompensaOk, Snackbar.LENGTH_LONG);
                snackbar.getView().setBackgroundColor(Color.rgb(0, 183, 51));
                snackbar.show();
            }
        } catch (Exception e) {
            Toast.makeText(this, R.string.recompensaFail + e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }



    public void carregarPunts() {

        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int dades = (mSharedPreference.getInt("puntuacio", -1));


        if (dades == -1) {
            punts = 0;
        } else {

            punts = dades;

        }


    }
}


