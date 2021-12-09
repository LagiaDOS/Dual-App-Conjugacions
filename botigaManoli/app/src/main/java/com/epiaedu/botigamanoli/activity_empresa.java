package com.epiaedu.botigamanoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class activity_empresa extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

        TextView telf = (TextView) findViewById(R.id.telf);
        TextView web = (TextView) findViewById(R.id.web);
        TextView direccio = (TextView) findViewById(R.id.direccio);
        TextView email = (TextView) findViewById(R.id.email);

        telf.setOnClickListener(this);
        web.setOnClickListener(this);
        direccio.setOnClickListener(this);
        email.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.telf:
                Intent trucar = new Intent(Intent.ACTION_DIAL);
                String telefon = getResources().getString(R.string.valTelefon);
                trucar.setData(Uri.parse("tel:" + telefon));
                startActivity(trucar);
                break;
            case R.id.web:
                Intent obrirPag = new Intent(Intent.ACTION_VIEW);
                String web = getResources().getString(R.string.valWeb);
                obrirPag.setData(Uri.parse(web));
                startActivity(obrirPag);
                break;
            case R.id.direccio:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + getString(R.string.valDireccio));
                Intent obrirMapa = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                obrirMapa.setPackage("com.google.android.apps.maps");

                if (obrirMapa.resolveActivity(getPackageManager()) != null) {
                    startActivity(obrirMapa);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.errorEmail, Toast.LENGTH_LONG);
                    toast.show();

                }


                break;
            case R.id.email:
                Intent obrirMail = new Intent(Intent.ACTION_SENDTO);
                obrirMail.setData(Uri.parse("mailto:"));
                obrirMail.putExtra(Intent.EXTRA_EMAIL, R.string.valEmail);

                if (obrirMail.resolveActivity(getPackageManager()) != null) {
                    startActivity(obrirMail);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.errorEmail, Toast.LENGTH_LONG);
                    toast.show();

                }


                break;

        }
    }

}