package com.epiaedu.botigamanoli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class activity_element extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        Bundle b = getIntent().getExtras();
        String descripcio = b.getString("descripcio");
        String categoria = b.getString("categoria");
        double preu = b.getDouble("preu");
        String fabricant = b.getString("fabricant");
        String comentari = b.getString("comentari");
        int posicio = b.getInt("posicio");

        String preuString = parsejarPreu(preu);


        TextView descText = (TextView) findViewById(R.id.descText);
        descText.setText(descripcio);

        TextView catText = (TextView) findViewById(R.id.catText);
        catText.setText(categoria);

        TextView preuText = (TextView) findViewById(R.id.preuText);

        preuText.setText(preuString.replace(".", ","));

        TextView fabricantText = (TextView) findViewById(R.id.fabricantText);
        fabricantText.setText(fabricant);

        EditText comentariText = (EditText) findViewById(R.id.comentari);
        comentariText.setText(comentari);

        Button desar = (Button) findViewById(R.id.desar);
        /*@Override
        public void onSaveInstanceState(Bundle savedInstanceState) {

            savedInstanceState.putInt("MyIntKey", myInt);
            savedInstanceState.putString("MyStringKey", myString);

            super.onSaveInstanceState(savedInstanceState);
        }*/
        desar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornar = new Intent();

                retornar.putExtra("comentari", comentariText.getText().toString());
                retornar.putExtra("descripcio", descripcio);
                setResult(Activity.RESULT_OK, retornar);
                finish();
            }
        });

        comentariText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    Intent retornar = new Intent();

                    retornar.putExtra("comentari", comentariText.getText().toString());
                    retornar.putExtra("descripcio", descripcio);
                    setResult(Activity.RESULT_OK, retornar);
                    finish();
                }
                return false;
            }
        });

    }

    public String parsejarPreu(double preu) {

        String preuString = Double.toString(preu);

        return preuString;
    }
}